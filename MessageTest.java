import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * J-Unit testing for Message class.
 *
 * @author  Hwansu Kim (Billy)
 * @version 01/29/2021
 */
public class MessageTest
{

    public MessageTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    // EXPECTED TESTS //
    @Test
    public void testConstructor() {
        Message testMessage = new Message("Test");
        assertEquals("Test", testMessage.getText());
    }
    
    @Test
    public void testSetsAndGets() {
        Message testMessage = new Message("Get Set Test");
        
        assertEquals(Color.BLACK, testMessage.getColor());
        assertEquals(12, testMessage.getFontSize());
        
        testMessage.setColor(Color.CYAN);
        assertEquals(Color.CYAN, testMessage.getColor());
        
        testMessage.setFontSize(23);
        assertEquals(23, testMessage.getFontSize());
        
        testMessage.setPriority(Message.MessagePriority.HIGH);
        assertEquals(Message.MessagePriority.HIGH, testMessage.getPriority());
    }
    
    // EXCEPTION THROW TEST //
    @Test (expected = IllegalArgumentException.class)
    public void testConstrTextNull() {
        new Message(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConstrTextEmpty() {
        new Message("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetTextNull() {
        Message testMessage = new Message("Null setText Test");
        testMessage.setText(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetTextEmpty() {
        Message testMessage = new Message("Empty setText Test");
        testMessage.setText("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetColorNull() {
        Message testMessage = new Message("Null setColor Test");
        testMessage.setColor(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetFontSizeNegative() {
        Message testMessage = new Message("Null setFontSize Test");
        testMessage.setFontSize(-1);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetFontSizeOver() {
        Message testMessage = new Message("Null setFontSize Test");
        testMessage.setFontSize(421);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetPriorityNull() {
        Message testMessage = new Message("Null setPriority Test");
        testMessage.setPriority(null);
    }
}
