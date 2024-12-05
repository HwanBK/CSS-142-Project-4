import java.awt.Color;
/**
 * Supplier code for Message class.
 *
 * @author Hwansu Kim (Billy)
 * @version 01/29/2022
 */
public class Message {
    
    // ENUM //
    public enum MessagePriority {
        LOW, MEDIUM, HIGH
    }

    // INSTANCE DATA //
    private String          text;
    private Color           color;
    private int             fontSize;
    private MessagePriority priority;

    // CONSTRUCTORS //
    /**
     *  Message constructor with a single string parameter.
     * 
     *  @param text     text that makes up the message; string type.
     */
    public Message(String text) {
        this(text, Color.BLACK, 12, MessagePriority.LOW);
    }

    /**
     *  Message constructor with multiple parameters.
     *  
     *  @param text         text that makes up the message; string type.
     *  @param color        any color object from java.awt.Color.
     *  @param fontSize     message font size in pixels; integer type.
     *  @param priority     the priority level for a message; MessagePriority type.
     */
    public Message(String text, Color color, int fontSize, MessagePriority priority) {
        checkNonNullEmpty(text);

        setText(text);
        setColor(color);
        setFontSize(fontSize);
        setPriority(priority);
    }

    
    // GET METHODS //
    /**
     *  Accessor for the string text.
     */
    public String getText() {
        return text;
    }

    /**
     *  Accessor for the color object.
     */
    public Color getColor() {
        return color;
    }

    /**
     *  Accessor for the font size integer.
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     *  Accessor for the message priority.
     */
    public MessagePriority getPriority() {
        return priority;
    }

    
    // SET METHODS //
    /**
     *  Mutator for the text string.
     *  
     *  @param  text        text that makes up the message; string type.
     */
    public void setText(String text) {
        checkNonNullEmpty(text);
        this.text = text;
    }
    
    /**
     *  Mutator for the color object.
     *  
     *  @param color        any color object from java.awt.Color.
     */
    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("color must not be null.");
        }
        this.color = color;
    }
    
    /**
     *  Mutator for the font size integer.
     *  
     *  @param fontSize     message font size in pixels; integer type.
     */
    public void setFontSize(int fontSize) {
        if (fontSize < 1 || fontSize > 420) {
            throw new IllegalArgumentException("Font size must be greater than 1 and less than 420.");
        }
        this.fontSize = fontSize;
    }
    
    /**
     *  Mutator for the message priority.
     *  
     *  @param priority     the priority level for a message; MessagePriority type.
     */
    public void setPriority(MessagePriority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("priority must not be null.");
        }
        this.priority = priority;
    }
    
    
    // MISC. METHODS //
    /**
     * Returns the string for output displaying.
     * 
     * @return text     returns the provided text.
     */
    public String toString() {
        return text;
    }
    
    /**
     *  Null and empty exceptions for methods that have a string parameter.
     *  
     *  @param  strObj      any parameter of type string.
     */
    private void checkNonNullEmpty(String strObj) {
        if (strObj == null || strObj.isEmpty()) {
            throw new IllegalArgumentException(strObj + "must not be null or empty.");
        }
    }
}
