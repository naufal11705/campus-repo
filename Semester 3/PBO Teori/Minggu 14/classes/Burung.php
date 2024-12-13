<?php

namespace classes;

class Burung extends EntitasTerbang
{
    protected $panjangParuh;

    public function __construct($nama, $jumlahSayap)
    {
        parent::__construct($nama, $jumlahSayap);
    }
    public function bersuara()
    {
        echo "Burung dengan nama {$this->nama} sedang bersuara:'Cit..cit..cit'<br/>";
    }
}
?>