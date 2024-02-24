package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;

import java.util.Vector;

/**
 * The RanklistModel class represents a table model for displaying a ranklist of players.
 * Must be serializable.
 */
public class RanklistModel extends AbstractTableModel {

    /** The column names for the ranklist table. */
    private String[] columnNames = {"Name", "Score"};

    /** An array containing Player objects representing the ranklist entries. */
    private Vector<Player> data;

    /**
     * Constructs a RanklistModel object with data loaded from the specified file.
     *
     * @param src The source file from which to load data.
     * @throws IOException If an I/O error occurs while loading data from the file.
     */
    public RanklistModel(File src) throws IOException { ;
        if(src.exists())
            load(src);
        else {
            data = new Vector<>();
        }
    }

    /**
     * Loads data from the specified file using ObjectMapper.
     *
     * @param from The file from which to load data.
     * @throws IOException If an I/O error occurs while loading data from the file.
     */
    private void load(File from) throws IOException {
        ObjectMapper in = new ObjectMapper();
        data = in.readValue(from, new TypeReference<Vector<Player>>() { });
    }

    /**
     * Stores data to the specified file using ObjectMapper.
     *
     * @param to The file to which to store data.
     * @throws IOException If an I/O error occurs while storing data to the file.
     */
    public void store(File to) throws IOException {
        ObjectMapper out = new ObjectMapper();
        out.writeValue(to, data);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Player p = data.elementAt(i);
        if(i1 == 0)
            return p.getName();
        else
            return p.getScore();
    }

    /**
     * Adds a new row to the ranklist.
     *
     * @param p The player to add to the ranklist.
     */
    public void addNewRow(Player p){
        data.add(p);
        fireTableRowsInserted(data.size() - 2,data.size() - 1);

    }

    /**
     * Removes the last row from the ranklist.
     */
    public void removeLastRow(){
        data.remove(data.size() - 1);
        fireTableRowsDeleted(data.size() - 2,data.size() - 1);
    }
    
}

