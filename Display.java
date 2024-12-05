import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * Supplier code for displaying messages on a panel by calling the Message class.
 *
 * @author Hwansu Kim (Billy)
 * @version 01/29/2022
 */
public class Display {
    
    // INSTANCE DATA //
    private boolean isOn;
    private int     messageCount;
    private int     totalMessageLength;
    private int     yCoorCount;
    private Message message;
    
    DrawingPanel myMonitor = new DrawingPanel("monitor.png");
    Graphics myGraphics = myMonitor.getGraphics();
    
    // CONSTRUCTOR //
    /**
     *  Constructor for the display class.
     */
    public Display() {
        turnOff();
        yCoorCount = 70;
    }
    
    /**
     *  Simulates a monitor that is off using Graphics objects.
     */
    public void turnOff() {
        isOn = false;
        myGraphics.setColor(Color.DARK_GRAY);
        myGraphics.fillRect(46, 70, 750, 425);
        sleep(1000);
    }
    
    /**
     *  Simulates a monitor that is on using Graphics objects.
     */
    public void turnOn() {
        isOn = true;
        myGraphics.setColor(Color.WHITE);
        myGraphics.fillRect(46, 70, 750, 425);
        sleep(2000);
    }
    
    /**
     *  Simulates a cleared monitor; only functions if isOn is true.
     */
    public void clearDisplay() {
        if (isOn) {
            myGraphics.setColor(Color.WHITE);
            myGraphics.fillRect(46, 70, 750, 425);
            yCoorCount = 70;
        } else {
            myGraphics.setColor(Color.DARK_GRAY);
            myGraphics.fillRect(46, 70, 750, 425);
        }
    }
    
    /**
     *  Accepts, processes, and assembles the Message class components.
     *  
     *  @param  message     Instanced data from the Message class; Message type.
     */
    public void showMessage(Message message) {
        if (isOn) {
            if (yCoorCount + message.getFontSize() > 420) {
                clearDisplay();
            }
            myGraphics.setColor(message.getColor());
            Font myFont = new Font("Times New Roman", Font.PLAIN, message.getFontSize());
            myGraphics.setFont(myFont);
            
            myGraphics.drawString(message.toString(), 50, yCoorCount + message.getFontSize());
            
            yCoorCount += message.getFontSize();
            messageCount += 1;
            totalMessageLength += message.getText().length();
            if (message.getPriority() == Message.MessagePriority.LOW) {
                sleep(250);
            } else if (message.getPriority() == Message.MessagePriority.MEDIUM){
                sleep(500);
            } else if (message.getPriority() == Message.MessagePriority.HIGH) {
                sleep(1000);
            }
        }
    }
    
    
    // GET METHODS //
    /**
     * Accessor for isOn boolean.
     */
    public boolean getIsOn() {
        return isOn;
    }
    
    /**
     * Accessor for the messageCount integer.
     */
    public int getMessageCount() {
        return messageCount;
    }
    
    public int getTotalMessageLength() {
        return totalMessageLength;
    }
    
    
    // MISC. //
    /**
     * Method for temporarily pausing the program when called.
     * 
     * @param milliseconds      time in milliseconds; integer type.
     */
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            ;
        }
    }
    
    
    // WIP EXTRA CREDIT //
    private String displayLine(Message message) {
        FontMetrics myFontMet = myGraphics.getFontMetrics();
        int width = myFontMet.stringWidth(message.getText());
        
        return null; //temp stub
    }
}
