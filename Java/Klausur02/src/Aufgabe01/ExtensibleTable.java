package Aufgabe01;// Diese Datei *nicht* ändern!
import java.util.Iterator;

/**
 * Interface für eine Tabelle, die um neue Zeilen und Spalten erweitert werden
 * kann. Der Index für Zeilen (row) und Spalten (column) beginnt mit 0.
 */
public interface ExtensibleTable<E> {
    /** Gibt den Wert eines Feldes der Tabelle zurück. */
    E getField(int row, int column);

    /** Weist einem Feld einen neuen Wert zu. */
    void setField(int row, int column, E value);

    /** Erweitert die Tabelle um eine leere Zeile. */
    void addRow();

    /** Erweitert die Tabelle um eine leere Spalte. */
    void addColumn();

    /** Erzeugt einen Iterator für den Tabelleninhalt. */
    Iterator<E> iterator();
}
