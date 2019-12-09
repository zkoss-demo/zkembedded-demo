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
@NotifyCommand(value = "toClient", onChange = "_vm_.zssSrc")
@ToClientCommand("toClient")
@ToServerCommand({"loadDemoXlsx", "toggleToolbarVisible", "toggleSheetbarVisible", "toggleFormulabarVisible"})
public class DemoVM {
	String zssSrc = "/book/blank.xlsx";
	boolean toolbarVisible = true;
	boolean sheetbarVisible = true;
	boolean formulabarVisible = true;

	public String getZssSrc() {
		return zssSrc;
	}

	public void setZssSrc(String zssSrc) {
		this.zssSrc = zssSrc;
	}

	public boolean isToolbarVisible() {
		return toolbarVisible;
	}

	public void setToolbarVisible(boolean toolbarVisible) {
		this.toolbarVisible = toolbarVisible;
	}

	public boolean isSheetbarVisible() {
		return sheetbarVisible;
	}

	public void setSheetbarVisible(boolean sheetbarVisible) {
		this.sheetbarVisible = sheetbarVisible;
	}

	public boolean isFormulabarVisible() {
		return formulabarVisible;
	}

	public void setFormulabarVisible(boolean formulabarVisible) {
		this.formulabarVisible = formulabarVisible;
	}

	@Command
	public void uploadXlsx(@BindingParam("file") Object file) {
		file.toString();
	}

	@Command
	@NotifyChange("zssSrc")
	public void loadDemoXlsx() {
		zssSrc = "/book/demo_sample.xlsx";
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
