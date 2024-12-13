<?php

namespace classes;

class KendaraanUdara extends EntitasTerbang
{
    protected $jumlahMesin;
    protected $kapasitasPenumpang;

    public function __construct($nama, $jumlahSayap)
    {
        $this->jumlahMesin = 1;
        $this->kapasitasPenumpang = 0;
    }

    public function getJumlahMesin()
    {
        return $this->jumlahMesin;
    }

    public function setJumlahMesin($jumlahMesin)
    {
        $this->jumlahMesin = $jumlahMesin;
    }
}