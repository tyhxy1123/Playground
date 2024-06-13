package Aufgabe01;

import java.util.*;

public class MyExtensibleTable implements ExtensibleTable<String> {

    private List<List<String>> tableBody;

    private int numberRows;
    private int numberColumns;



    private final static String EMPTY = "";

    public MyExtensibleTable(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException();
        }
        tableBody = new ArrayList<List<String>>();
        numberColumns = columns;
        numberRows = rows;
        for (int i = 0; i < numberRows; i++) {
            List<String> emptyRow = new ArrayList<String>();
            for (int j = 0; j < numberColumns; j++) {
                emptyRow.add(EMPTY);
            }
            tableBody.add(emptyRow);
        }
    }

    @Override
    public String getField(int row, int column) {
        if(row > numberRows || column > numberColumns){
            throw new NoSuchElementException();
        }
        if(tableBody.get(row).get(column) == EMPTY){
            throw new NoSuchElementException();
        }
        return tableBody.get(row).get(column);
    }

    @Override
    public void setField(int row, int column, String value) {
        tableBody.get(row).set(column, value);
    }

    @Override
    public Iterator<String> iterator() {
        return new ExtensibleTableIterator();
    }

    @Override
    public void addRow() {
        tableBody.add(new ArrayList<String>());
        numberRows += 1;
    }

    @Override
    public void addColumn() {
        for (var row: tableBody) {
            row.add(EMPTY);
        }
        numberColumns += 1;
    }

    private class ExtensibleTableIterator implements Iterator<String> {

        private List<String> index = new LinkedList<String>();

        public ExtensibleTableIterator() {
            for(List<String> rows : tableBody){
                index.addAll(rows);
            }
        }

        @Override
        public String next() {
            String str = null;
            if(!index.isEmpty()){
                str = index.get(0);
            }
            else{
                throw new NullPointerException();
            }
            index.remove(0);
            return str;
        }

        @Override
        public boolean hasNext() {
            return !index.isEmpty();
        }
    }

}