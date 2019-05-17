import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneTest extends JFrame
{
    // Текстовый редактор
    private  JTextPane textEditor = null;
    // Стили редактора
    private  Style     heading    = null; // стиль заголовка
    private  Style     normal     = null; // стиль текста

    private  final  String      STYLE_heading = "heading",
            STYLE_normal  = "normal" ,
            FONT_style    = "Times New Roman";
    private  final  String[][]  TEXT = {
            {"Компонент JTextPane \r\n"                           , "heading"},
            {"\r\n"                                               , "normal" },
            {"JTextPane незаменим при создании в приложении  \r\n", "normal" },
            {"многофункционального текстового редактора.\r\n"     , "normal" }};
    public JTextPaneTest()
    {
        super("Пример редактора JTextPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание редактора
        textEditor = new JTextPane();
        // Определение стилей редактора
        createStyles(textEditor);
        // Загрузка документа
        loadText(textEditor);
        changeDocumentStyle(textEditor);
        // Размещение редактора в панели содержимого
        getContentPane().add(new JScrollPane(textEditor));
        // Открытие окна
        setSize(380, 240);
        setVisible(true);
    }

    private void createStyles(JTextPane editor)
    {
        // Создание стилей
        normal = editor.addStyle(STYLE_normal, null);
        StyleConstants.setFontFamily(normal, FONT_style);
        StyleConstants.setFontSize(normal, 16);
        // Наследуем свойстdо FontFamily
        heading = editor.addStyle(STYLE_heading, normal);
        StyleConstants.setFontSize(heading, 24);
        StyleConstants.setBold(heading, true);
    }

    private void loadText(JTextPane editor)
    {
        // Загружаем в документ содержимое
        for (int i = 0; i < TEXT.length; i++) {
            Style style = (TEXT[i][1].equals(STYLE_heading)) ?
                    heading : normal;
            insertText(editor, TEXT[i][0], style);
        }
    }

    private void changeDocumentStyle(JTextPane editor)
    {
        // Изменение стиля части текста
        SimpleAttributeSet blue = new SimpleAttributeSet();
        StyleConstants.setForeground(blue, Color.GREEN);
        StyledDocument doc = editor.getStyledDocument();
        doc.setCharacterAttributes(0, 9, blue, false);
    }

    private void insertText(JTextPane editor, String string,
                            Style style)
    {
        try {
            Document doc = editor.getDocument();
            doc.insertString(doc.getLength(), string, style);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new JTextPaneTest();
    }
}