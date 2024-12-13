<?php

namespace classes;

class EntitasTerbang
{
    protected $nama;
    protected $jumlahSayap;

    public function __construct($nama, $jumlahSayap)
    {
        $this->nama = "";
        $this->jumlahSayap = 0;        
    }

    public function getJumlahSayap()
    {
        return $this->jumlahSayap;
    }

    public function setJumlahSayap($jumlahSayap)
    {
        $this->jumlahSayap = $jumlahSayap;
    }

    public function getName()
    {
        return $this->nama;
    }

    public function setNama($nama)
    {
        $this->nama = $nama;
    }

    public function terbang()
    {
        echo "Burung dengan nama {$this->nama} sedang terbang: 'Wusssh...'<br/>";
    }
}

?>