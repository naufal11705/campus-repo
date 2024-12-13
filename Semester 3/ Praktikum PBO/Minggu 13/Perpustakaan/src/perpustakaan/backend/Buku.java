/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Buku {
    private int idbuku;
    private Kategori kategori = new Kategori();
    private String judul;
    private String penulis;
    private String penerbit;

    public Buku() {
    }

    public Buku(Kategori kategori, String judul, String penulis, String penerbit) {
        this.kategori = kategori;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }
    
    public String toString()
    {
        return judul;
    }

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
    public ArrayList<Buku> getAll(){
        ArrayList<Buku> ListBuku = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + "         b.idbuku AS idbuku, "
                                    + "         b.judul AS judul, "
                                    + "         b.penerbit AS penerbit, "
                                    + "         b.penulis AS penulis, "
                                    + "         k.idkategori AS idkategori, "
                                    + "         k.nama AS nama, "
                                    + "         k.keterangan AS keterangan "
                                    + "         FROM buku b "
                                    + "         LEFT JOIN kategori k ON b.idkategori = k.idkategori ");
        
        try{
            while(rs.next()){
                Buku buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                
                ListBuku.add(buku);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListBuku;
    }
    
    public Buku getById(int id){
        Buku buku = new Buku();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + "         b.idbuku AS idbuku, "
                                    + "         b.judul AS judul, "
                                    + "         b.penerbit AS penerbit, "
                                    + "         b.penulis AS penulis, "
                                    + "         k.idkategori AS idkategori, "
                                    + "         k.nama AS nama, "
                                    + "         k.keterangan AS keterangan "
                                    + "         FROM buku b "
                                    + "         LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                                    + "         WHERE idbuku = '" + id + "'");

        try{
            while(rs.next()){
                buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return buku;
    }    
    
    public ArrayList<Buku> search(String keyword) {
        ArrayList<Buku> ListBuku = new ArrayList<>();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + "         b.idbuku AS idbuku, "
                                    + "         b.judul AS judul, "
                                    + "         b.penerbit AS penerbit, "
                                    + "         b.penulis AS penulis, "
                                    + "         k.idkategori AS idkategori, "
                                    + "         k.nama AS nama, "
                                    + "         k.keterangan AS keterangan "
                                    + "         FROM buku b "
                                    + "         LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                                    + "         WHERE k.nama LIKE '%" + keyword + "%' "
                                    + "             OR b.judul LIKE '%" + keyword + "%' " 
                                    + "             OR b.penerbit LIKE '%" + keyword + "%' " 
                                    + "             OR b.penulis LIKE '%" + keyword + "%' ");

        try {
            while (rs.next()) {
                Buku buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));

                ListBuku.add(buku);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListBuku;
    }    
    
    public void save() {
        if (getById(idbuku).getIdbuku() == 0) {
            String SQL = "INSERT INTO buku (judul, idkategori, penulis, penerbit) VALUES ('"
            + this.judul + "', '"
            + this.getKategori().getIdkategori() + "', '"
            + this.penulis + "', '"
            + this.penerbit + "')";

            this.idbuku = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE buku SET "
                    + "judul = '" + this.judul + "', "
                    + "idkategori = '" + this.getKategori().getIdkategori() + "' "
                    + "penulis = '" + this.penulis + "' "
                    + "penerbit = '" + this.penerbit + "' "
                    + "WHERE idbuku = '" + this.idbuku + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM buku WHERE idbuku = '" + this.idbuku + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public boolean cekIdBuku(String id) {
        boolean isAvailable = false;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM buku WHERE idbuku = '" + id + "'");
        
        try {
            if (!rs.next()) {
            isAvailable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isAvailable;
    }
}
