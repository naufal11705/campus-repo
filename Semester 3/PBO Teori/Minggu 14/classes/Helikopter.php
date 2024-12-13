<?php

namespace classes;

class Helikopter extends KendaraanUdara
{

    public function __construct($jumlahMesin, $kapasitasPenumpang)
    {
        $this->jumlahMesin = 1;
        $this->kapasitasPenumpang = 0;
    }
}