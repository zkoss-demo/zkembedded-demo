package zk.demo;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.NotifyCommand;
import org.zkoss.bind.annotation.ToClientCommand;
import org.zkoss.bind.annotation.ToServerCommand;

/**
 * @author jameschu
 */
@NotifyCommand(value = "toClient", onChange = "_vm_.workbookSrc")
@ToClientCommand("toClient")
@ToServerCommand({"loadDemoXlsx", "toggleToolbarVisible", "toggleSheetbarVisible", "toggleFormulabarVisible"})
public class DemoVM {
	private String workbookSrc = "/book/blank.xlsx";
	private boolean toolbarVisible = true;
	private boolean sheetbarVisible = true;
	private boolean formulabarVisible = true;

	public String getWorkbookSrc() {
		return workbookSrc;
	}

	public boolean isToolbarVisible() {
		return toolbarVisible;
	}

	public boolean isSheetbarVisible() {
		return sheetbarVisible;
	}

	public boolean isFormulabarVisible() {
		return formulabarVisible;
	}

	@Command
	public void uploadXlsx(@BindingParam("file") Object file) {
		file.toString();
	}

	@Command
	@NotifyChange("workbookSrc")
	public void loadDemoXlsx() {
		workbookSrc = "/book/demo_sample.xlsx";
	}

	@Command
	@NotifyChange("toolbarVisible")
	public void toggleToolbarVisible() {
		toolbarVisible = !toolbarVisible;
	}

	@Command
	@NotifyChange("sheetbarVisible")
	public void toggleSheetbarVisible() {
		sheetbarVisible = !sheetbarVisible;
	}

	@Command
	@NotifyChange("formulabarVisible")
	public void toggleFormulabarVisible() {
		formulabarVisible = !formulabarVisible;
	}
}
