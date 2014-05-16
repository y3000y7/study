import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;


public class Editor extends AbstractDecoratedTextEditor{
	public Editor(){
		setDocumentProvider(new TextFileDocumentProvider());
	}
}