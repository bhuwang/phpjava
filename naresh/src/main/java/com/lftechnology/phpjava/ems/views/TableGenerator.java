package com.lftechnology.phpjava.ems.views;

import de.vandermeer.asciitable.v2.RenderedTable;
import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthAbsoluteEven;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;

/**
 * TableGenerator
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public class TableGenerator {
    private int numberOfColums;
    private V2_AsciiTable table = new V2_AsciiTable();
    private V2_AsciiTableRenderer renderer = new V2_AsciiTableRenderer();

    public TableGenerator(String[] columns) {
        this.renderer.setTheme(V2_E_TableThemes.UTF_HEAVY.get());
        this.renderer.setWidth(new WidthAbsoluteEven(160));
        this.generateHeader(columns);
    }

    public void renderTable() {
        RenderedTable rt = this.renderer.render(this.table);
        System.out.println(rt);
    }

    private void generateHeader(String[] colums) {
        this.table.addRule();
        this.table.addRow(colums);
        this.table.addRule();
    }

    public void addRow(String[] row) {
        this.table.addRow(row);
        this.table.addRule();
    }

}
