<?php

namespace classes;

class KakakTua extends Burung
{
    public function __construct($nama, $jumlahSayap, $panjangParuh)
    {
        parent::__construct($nama, $jumlahSayap, $panjangParuh);
    }

    public function meniruSuaraManusia()
    {
        echo "Burung dengan nama {$this->nama} sedang terbang: 'Wusssh...'<br/>";
    }
}
?>