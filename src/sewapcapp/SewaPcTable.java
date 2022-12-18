/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewapcapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author GM
 */
@Entity
@Table(name = "sewa_pc_table", catalog = "sewa_pc", schema = "")
@NamedQueries({
    @NamedQuery(name = "SewaPcTable.findAll", query = "SELECT s FROM SewaPcTable s")
    , @NamedQuery(name = "SewaPcTable.findByUserId", query = "SELECT s FROM SewaPcTable s WHERE s.userId = :userId")
    , @NamedQuery(name = "SewaPcTable.findByNama", query = "SELECT s FROM SewaPcTable s WHERE s.nama = :nama")
    , @NamedQuery(name = "SewaPcTable.findByWaktu", query = "SELECT s FROM SewaPcTable s WHERE s.waktu = :waktu")
    , @NamedQuery(name = "SewaPcTable.findByHarga", query = "SELECT s FROM SewaPcTable s WHERE s.harga = :harga")})
public class SewaPcTable implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "Waktu")
    private String waktu;
    @Basic(optional = false)
    @Column(name = "Harga")
    private int harga;

    public SewaPcTable() {
    }

    public SewaPcTable(Integer userId) {
        this.userId = userId;
    }

    public SewaPcTable(Integer userId, String nama, String waktu, int harga) {
        this.userId = userId;
        this.nama = nama;
        this.waktu = waktu;
        this.harga = harga;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        Integer oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        String oldNama = this.nama;
        this.nama = nama;
        changeSupport.firePropertyChange("nama", oldNama, nama);
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        String oldWaktu = this.waktu;
        this.waktu = waktu;
        changeSupport.firePropertyChange("waktu", oldWaktu, waktu);
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        int oldHarga = this.harga;
        this.harga = harga;
        changeSupport.firePropertyChange("harga", oldHarga, harga);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SewaPcTable)) {
            return false;
        }
        SewaPcTable other = (SewaPcTable) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sewapcapp.SewaPcTable[ userId=" + userId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
