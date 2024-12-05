import java.awt.Color;
/**
 * Client code that demos Display and Message classes.
 *
 * @author Hwansu Kim (Billy)
 * @version 01/29/2022
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.print('\u000c');
        
        Display myDisplay = new Display();
        myDisplay.turnOn();
        
        Message myMessage = new Message("My eyes are numb", Color.GREEN, 10, Message.MessagePriority.MEDIUM);
        for (int loop = 0; loop < 10; loop++) {
            myDisplay.showMessage(myMessage);
            myMessage.setFontSize(myMessage.getFontSize() + 10);
        }
        
        Message myMessage2 = new Message("I should get glasses");
        myDisplay.showMessage(myMessage2);
                
        Message myMessage3 = new Message("3");
        myMessage3.setText("Okay bye.");
        myMessage3.setColor(Color.BLUE);
        myMessage3.setFontSize(100);
        myMessage3.setPriority(Message.MessagePriority.HIGH);
        myDisplay.showMessage(myMessage3);
        
        myDisplay.turnOff();
        
        Message myMessage4 = new Message ("You shouldn't be able to see this");
        myMessage4.setColor(Color.WHITE);
        myDisplay.showMessage(myMessage4);
        
        System.out.println("Message count: " + myDisplay.getMessageCount());
        System.out.println("Total message length: " + myDisplay.getTotalMessageLength());
    }
}
