package com.example.demo.HopDong.entity;

import com.example.demo.KhachThue.entity.KhachThueEntity;
import com.example.demo.PhongTro.entity.PhongTroEntity;
import com.example.demo.ThanhToan.entity.ThanhToanEntity;
import com.example.demo.global.Common;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOP_DONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopDongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "MA_HOP_DONG", nullable = false, unique = true, length = 10)
    private String maHopDong;

    @Column(name = "NGAY_BAT_DAU")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;

    @Column(name = "NGAY_KET_THUC")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    @Column(name = "TIEN_DAT_COC")
    private Float tienDatCoc;

    @Column(name = "CHU_KY_THANH_TOAN", length = 50)
    private Common.ChuKyThanhToanEnum chuKyThanhToan;

    @Enumerated(EnumType.STRING)
    @Column(name = "TINH_TRANG_THANH_TOAN", length = 50)
    private Common.TinhTrangThanhToanEnum tinhTrangThanhToan;

    @Column(name = "NGUOI_TAO", length = 4000)
    private String nguoiTao;

    @Column(name = "NGAY_TAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "NGUOI_SUA", length = 4000)
    private String nguoiSua;

    @Column(name = "NGAY_SUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    @Column(name = "IS_DELETE")
    private Boolean isDelete = false;

    @OneToMany(mappedBy = "hopDong", cascade = CascadeType.ALL)
    private List<ThanhToanEntity> thanhToan;

    @ManyToOne
    @JoinColumn(name = "id_khach_thue", referencedColumnName = "id")
    private KhachThueEntity khachThue;

    @PrePersist
    public void generateMaHopDong() {
        this.maHopDong = "HĐTN-No".concat(String.valueOf(id));
    }


}