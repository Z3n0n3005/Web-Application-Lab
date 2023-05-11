package Lab_7;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/** A JEditorPane with support for loading and saving the
 *  document. The document should be one of two
 *  types: "text/plain" (default) or "text/html".
 */

public class DocumentPane extends JEditorPane {
  public static final String TEXT = "text/plain";
  public static final String HTML = "text/html";

  private boolean loaded = false;
  private String filename = "";

  /** Set the current page displayed in the editor pane,
   *  replacing the existing document.
   */
  @Override
  public void setPage(URL url) {
    loaded = false;
    try {
      System.out.println(url);
      super.setPage(url);
      // super.setPage(null);
      System.out.println(super.getPage());
      File file = new File(super.getPage().toString());
      setFilename(file.getName());
      loaded = true;
    } catch (IOException ioe) {
      System.err.println("Unable to set page: " + url);
    }
  }

  /** Set the text in the document page, replace the exiting
   *  document.
   */

  public void setText(String text) {
    super.setText(text);
    // super.setText("<html><body><h1>hello</h1></body></html>");
    System.out.println(super.getText());
    setFilename("");
    loaded = true;
  }

  /** Load a file into the editor pane.
   *
   *  Note that the setPage method of JEditorPane checks the
   *  URL of the currently loaded page against the URL of the
   *  new page to load.  If the two URLs are the same, then
   *  the page is <b>not</b> reloaded.
   */

  public void loadFile(String filename) {
    try {
      File file = new File(filename);
      setPage(file.toURI().toURL());
    } catch (IOException mue) {
      System.err.println("Unable to load file: " + filename);
    }
  }

  public void saveFile(String filename) {
    try {
      File file = new File(filename);
      FileWriter writer = new FileWriter(file);
      writer.write(getText());
      writer.close();
      setFilename(file.getName());
    } catch (IOException ioe) {
      System.err.println("Unable to save file: " + filename);
    }
  }

  /** Return the name of the file loaded into the editor pane. */

  public String getFilename() {
    return(filename);
  }

  /** Set the filename of the document. */

  public void setFilename(String filename) {
    this.filename = filename;
  }

  /** Return true if a document is loaded into the editor
   *  page, either through <code>setPage</code> or
   *  <code>setText</code>.
   */

  public boolean isLoaded() {
    return(loaded);
  }
}