package Lab_7;
import javax.xml.transform.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/** A document editor to process XML and XSL text using
 *  XSLT and presenting the results as HTML. Three tabbed panes
 *  are presented:  an editable text pane for the XML document,
 *  an editable text pane for the XSL style sheet, and a non-
 *  editable HTML pane for the HTML result. If an XML and XSL
 *  file are loaded, then selecting the XSLT tab will perform
 *  the transformation and present the results. If there is
 *  a problem processing the XML or XSL document, then a
 *  message box is popped up describing the problem.
 */

public class XsltExample extends JFrame
                         implements ChangeListener {
  private static final int XML  = 0;
  private static final int XSL  = 1;
  private static final int XSLT = 2;
  private static final String DEFAULT_TITLE = "XSLT Example";
  private static final String[] tabTitles =
                                  { "XML", "XSL", "XSLT" };
  private static final String[] extensions =
                                  { "xml", "xsl", "html" };
  private Action openAction, saveAction, exitAction;
  private JTabbedPane tabbedPane;
  private DocumentPane[] documents;
  private XslTransformer transformer;

  public XsltExample() {
    super(DEFAULT_TITLE);
    transformer = new XslTransformer();
    WindowUtilities.setNativeLookAndFeel();
    Container content = getContentPane();
    content.setBackground(SystemColor.control);

    // Set up menus
    JMenuBar menubar = new JMenuBar();
    openAction = new OpenAction();
    saveAction = new SaveAction();
    exitAction = new ExitAction();
    JMenu fileMenu = new JMenu("File");
    fileMenu.add(openAction);
    fileMenu.add(saveAction);
    fileMenu.add(exitAction);
    menubar.add(fileMenu);
    setJMenuBar(menubar);

    // Set up tabbed panes
    tabbedPane = new JTabbedPane();
    documents = new DocumentPane[3];
    for(int i=0; i<3; i++) {
      documents[i] = new DocumentPane();
      JPanel panel = new JPanel();
      JScrollPane scrollPane = new JScrollPane(documents[i]);
      panel.add(scrollPane);
      tabbedPane.add(tabTitles[i], scrollPane);
    }
    documents[XSLT].setContentType(DocumentPane.HTML);
    // JEditorPane has a bug, whereas the setText method does
    // not properly recognize an HTML document that has a META
    // element containing a CONTENT-TYPE, unless the EditorKit
    // is first created through setPage. Xalan automatically
    // adds a META CONTENT-TYPE to the document. Thus,
    // preload a document containing a META CONTENT-TYPE.
    // documents[XSLT].loadFile("XSLT-Instructions.html");
    // src/main/webapp/exercise 5/book.xml
    documents[XML].loadFile("/media/vy/OneDrive/3/Sem 2/Web Application Development/lab/lab_7/Lab_7/src/main/java/Lab_7/book.xml");

    documents[XML].setEditable(false);
    tabbedPane.addChangeListener(this);
    content.add(tabbedPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 350);
    setVisible(true);
  }

  /** Checks to see which tabbed pane was selected by the
   *  user. If the XML and XSL panes hold a document, then
   *  selecting the XSLT tab will perform the transformation.
   */

  public void stateChanged(ChangeEvent event) {
    int index = tabbedPane.getSelectedIndex();
    switch (index) {
      case XSLT: if (documents[XML].isLoaded() &&
                     documents[XSL].isLoaded()) {
                   doTransform();
                 }
      case XML:
      case XSL:  updateMenuAndTitle(index);
                 break;
      default:
    }
  }

  /** Retrieve the documents in the XML and XSL pages
   *  as text (String), pipe into a StringReader, and
   *  perform the XSLT transformation. If an exception
   *  occurs, present the problem in a message dialog.
   */

  private void doTransform() {
    StringWriter strWriter = new StringWriter();
    try {
      Reader xmlInput =
        new StringReader(documents[XML].getText());
      Reader xslInput =
        new StringReader(documents[XSL].getText());
      transformer = new XslTransformer();
      transformer.process(xmlInput, xslInput, strWriter);
    } catch(TransformerException te) {
      JOptionPane.showMessageDialog(this,
                    "Error: " + te.getMessage());
    }
    System.out.println(strWriter.toString());
    documents[XSLT].setText(strWriter.toString());
  }

  /** Update the title of the application to present
   *  the name of the file loaded into the selected
   *  tabbed pane. Also, update the menu options (Save,
   *  Load) based on which tab is selected.
   */

  private void updateMenuAndTitle(int index) {
    if ((index > -1) && (index < documents.length)) {
      saveAction.setEnabled(documents[index].isLoaded());
      openAction.setEnabled(documents[index].isEditable());
      String title = DEFAULT_TITLE;
      String filename = documents[index].getFilename();
      if (filename.length() > 0) {
        title += " - [" + filename + "]";
      }
      setTitle(title);
    }
  }

  /** Open a file dialog to either load a new file to or save
   *  the existing file in the present document pane.
   */

  private void updateDocument(int mode) {
    int index = tabbedPane.getSelectedIndex();
    String description = tabTitles[index] + " Files";
    description = "book";
    String filename = ExtensionFileFilter.getFileName("src\\main\\webapp\\exercise 5",
                                            description,
                                            extensions[index],
                                            mode);
    if (filename != null) {
      if (mode==ExtensionFileFilter.SAVE) {
        documents[index].saveFile(filename);
      } else {
        documents[index].loadFile(filename);
      }
      updateMenuAndTitle(index);
    }
  }

  public static void main(String[] args) {
    new XsltExample();
  }

  // Open menu action to load a new file into a
  // document when selected.
  class OpenAction extends AbstractAction {
    public OpenAction() {
      super("Open ...");
    }
    public void actionPerformed(ActionEvent event) {
      updateDocument(ExtensionFileFilter.LOAD);
    }
  }

  // Save menu action to save the document in the
  // selected pane to a file.
  class SaveAction extends AbstractAction {
    public SaveAction() {
      super("Save");
      setEnabled(false);
    }
    public void actionPerformed(ActionEvent event) {
      updateDocument(ExtensionFileFilter.SAVE);
    }
  }

  // Exit menu action to close the application.
  class ExitAction extends AbstractAction {
    public ExitAction() {
      super("Exit");
    }
    public void actionPerformed(ActionEvent event) {
      System.exit(0);
    }
  }
}