import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        TextBuilder textBuilder = new TextBuilder();
        Director textDic = new Director(textBuilder);
        textDic.construct();

        System.out.println(textBuilder.getTextResult());

        Director htmlDic = new Director(new HTMLBuilder());
        htmlDic.construct();

        FrameBuilder frameBuilder = new FrameBuilder();
        Director frameDirector = new Director(frameBuilder);
        frameDirector.construct();
        JFrame frame = frameBuilder.getFrameResult();
        frame.setVisible(true);
    }

}
