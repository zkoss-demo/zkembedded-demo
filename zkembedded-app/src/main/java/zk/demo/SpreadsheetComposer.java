package zk.demo;

import io.keikai.ui.Spreadsheet;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;

import java.util.Map;

public class SpreadsheetComposer extends SelectorComposer {
    @Wire
    private Spreadsheet spreadsheet;

    @Listen("onImport = #spreadsheet")
    public void onImport(Event event){
        String fileName = ((Map)event.getData()).get("file").toString();
        spreadsheet.setSrc("/book/" + fileName);
    }

    @Listen("onToggleVisibility = #spreadsheet")
    public void onToggleVisibility(Event event){
        String ui = ((Map)event.getData()).get("ui").toString();

        switch (ui){
            case "toolbar":
                spreadsheet.setShowToolbar(!spreadsheet.isShowToolbar());
                break;
            case "sheetbar":
                spreadsheet.setShowSheetbar(!spreadsheet.isShowSheetbar());
                break;
            case "formulabar":
                spreadsheet.setShowFormulabar(!spreadsheet.isShowFormulabar());
                break;
        }
    }
}
