/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.backend;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class Pegawai {
    private int idpegawai;
    private String nama;
    private String alamat;
    private String telepon;
    private String jabatan;
    private String username;
    private String password;
    
    public Pegawai(){
        
    }

    public Pegawai(String nama, String alamat, String telepon, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.username = username;
        this.password = password;
    }
    
    public String toString()
    {
        return nama;
    }

    public int getIdpegawai() {
        return idpegawai;
    }

    public void setIdpegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public Pegawai getById(int id){
        Pegawai peg = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai WHERE idpegawai = '" + id + "'");

        try{
            while(rs.next()){
                peg.setIdpegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setTelepon(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return peg;
    }
    
    public ArrayList<Pegawai> getAll(){
        ArrayList<Pegawai> ListPegawai = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");
        
        try{
            while(rs.next()){
                Pegawai peg = new Pegawai();
                peg.setIdpegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setTelepon(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));
                
                ListPegawai.add(peg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListPegawai;
    }
    
    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> ListPegawai = new ArrayList<>();
        
        String sql = "SELECT * FROM pegawai WHERE " +
                     "nama LIKE '%" + keyword + "%' " +
                     "OR alamat LIKE '%" + keyword + "%' " +
                     "OR notelp LIKE '%" + keyword + "%' " +
                     "OR jabatan LIKE '%" + keyword + "%' " +
                     "OR username LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Pegawai peg = new Pegawai();
                peg.setIdpegawai(rs.getInt("idpegawai"));
                peg.setNama(rs.getString("nama"));
                peg.setAlamat(rs.getString("alamat"));
                peg.setTelepon(rs.getString("notelp"));
                peg.setJabatan(rs.getString("jabatan"));
                peg.setUsername(rs.getString("username"));
                peg.setPassword(rs.getString("password"));

                ListPegawai.add(peg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }
    
    public void save() {
        if (getById(idpegawai).getIdpegawai()== 0) {
            String SQL = "INSERT INTO pegawai (nama, alamat, notelp, jabatan, username, password) VALUES ('"
            + this.nama + "', '"
            + this.alamat + "', '"
            + this.telepon + "', '"
            + this.jabatan + "', '"
            + this.username + "', '"
            + this.password + "')";

            this.idpegawai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pegawai SET "
                    + "nama = '" + this.nama + "', "
                    + "alamat = '" + this.alamat + "', "
                    + "notelp = '" + this.telepon + "', "
                    + "jabatan = '" + this.jabatan + "', "
                    + "username = '" + this.username + "' "
                    + "WHERE idpegawai = '" + this.idpegawai + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idpegawai + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public boolean cekUsername(String username) {
        boolean isAvailable = false;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai WHERE username = '" + username + "'");
        
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
