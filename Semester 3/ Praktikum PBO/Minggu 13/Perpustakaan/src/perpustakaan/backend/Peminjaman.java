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
public class Peminjaman {
    private int idpeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private Pegawai pegawai = new Pegawai();
    private String tanggalpinjam;
    private String tanggalkembali;

    public Peminjaman() {
    }

    public Peminjaman(Anggota anggota, Buku buku, Pegawai pegawai, String tanggalpinjam, String tanggalkembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.pegawai = pegawai;
        this.tanggalpinjam = tanggalpinjam;
        this.tanggalkembali = tanggalkembali;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(String tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(String tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }
    
    public Peminjaman getById(int id){
        Peminjaman pmj = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + "         p.idpeminjaman AS idpeminjaman, "
                                    + "         p.tanggalpinjam AS tanggalpinjam, "
                                    + "         p.tanggalkembali AS tanggalkembali, "
                                    + "         b.idbuku AS idbuku, "
                                    + "         b.judul AS judul, "
                                    + "         b.penerbit AS penerbit, "
                                    + "         b.penulis AS penulis, "
                                    + "         a.idanggota AS idanggota, "
                                    + "         a.nama AS nama, "
                                    + "         a.alamat AS alamat, "
                                    + "         a.telepon AS telepon, "
                                    + "         pg.idpegawai AS idpegawai, "
                                    + "         pg.nama AS nama_pegawai, "
                                    + "         pg.jabatan AS jabatan "
                                    + "         FROM peminjaman p "
                                    + "         LEFT JOIN buku b ON p.idbuku = b.idbuku "
                                    + "         LEFT JOIN anggota a ON p.idanggota = a.idanggota "
                                    + "         LEFT JOIN pegawai pg ON p.idpegawai = pg.idpegawai "
                                    + "         WHERE idpeminjaman = '" + id + "'");

        
        try{
            while(rs.next()){
                pmj = new Peminjaman();
                pmj.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pmj.setTanggalpinjam(rs.getString("tanggalpinjam"));
                pmj.setTanggalkembali(rs.getString("tanggalkembali"));
                pmj.getBuku().setIdbuku(rs.getInt("idbuku"));
                pmj.getBuku().setJudul(rs.getString("judul"));
                pmj.getBuku().setPenerbit(rs.getString("penerbit"));
                pmj.getBuku().setPenulis(rs.getString("penulis"));
                pmj.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pmj.getAnggota().setNama(rs.getString("nama"));
                pmj.getAnggota().setAlamat(rs.getString("alamat"));
                pmj.getAnggota().setTelepon(rs.getString("telepon"));
                pmj.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                pmj.getPegawai().setNama(rs.getString("nama_pegawai"));
                pmj.getPegawai().setJabatan(rs.getString("jabatan"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pmj;
    }
    
    public ArrayList<Peminjaman> getAll(){
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + "         p.idpeminjaman AS idpeminjaman, "
                                    + "         p.tanggalpinjam AS tanggalpinjam, "
                                    + "         p.tanggalkembali AS tanggalkembali, "
                                    + "         b.idbuku AS idbuku, "
                                    + "         b.judul AS judul, "
                                    + "         b.penerbit AS penerbit, "
                                    + "         b.penulis AS penulis, "
                                    + "         a.idanggota AS idanggota, "
                                    + "         a.nama AS nama, "
                                    + "         a.alamat AS alamat, "
                                    + "         a.telepon AS telepon, "
                                    + "         pg.idpegawai AS idpegawai, "
                                    + "         pg.nama AS nama_pegawai, "
                                    + "         pg.jabatan AS jabatan "
                                    + "         FROM peminjaman p "
                                    + "         LEFT JOIN buku b ON p.idbuku = b.idbuku "
                                    + "         LEFT JOIN anggota a ON p.idanggota = a.idanggota "
                                    + "         LEFT JOIN pegawai pg ON p.idpegawai = pg.idpegawai ");
        
        try{
            while(rs.next()){
                Peminjaman pmj = new Peminjaman();
                pmj.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pmj.setTanggalpinjam(rs.getString("tanggalpinjam"));
                pmj.setTanggalkembali(rs.getString("tanggalkembali"));
                pmj.getBuku().setIdbuku(rs.getInt("idbuku"));
                pmj.getBuku().setJudul(rs.getString("judul"));
                pmj.getBuku().setPenerbit(rs.getString("penerbit"));
                pmj.getBuku().setPenulis(rs.getString("penulis"));
                pmj.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pmj.getAnggota().setNama(rs.getString("nama"));
                pmj.getAnggota().setAlamat(rs.getString("alamat"));
                pmj.getAnggota().setTelepon(rs.getString("telepon"));
                pmj.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                pmj.getPegawai().setNama(rs.getString("nama_pegawai"));
                pmj.getPegawai().setJabatan(rs.getString("jabatan"));
                
                ListPeminjaman.add(pmj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListPeminjaman;
    }
    
    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idanggota, idbuku, idpegawai, tanggalpinjam) VALUES ('"
            + this.getAnggota().getIdanggota() + "', '"
            + this.getBuku().getIdbuku() + "', '"
            + this.getPegawai().getIdpegawai() + "', '"
            + this.tanggalpinjam + "')";

            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE anggota SET "
                    + "tanggalkembali = '" + this.tanggalkembali + "' "
                    + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void update() {
        String SQL = "UPDATE peminjaman SET "
                + "tanggalkembali = '" + this.tanggalkembali + "' "
                + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }      
    
}
