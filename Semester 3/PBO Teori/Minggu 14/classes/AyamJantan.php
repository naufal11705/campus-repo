<?php
namespace classes;
class AyamJantan extends Burung
{
    public function __construct($nama)
    {
        parent::__construct($nama, 2);
    }

    public function berkokok()
    {
        echo "Ayam jantan bernama {$this->nama} berkokok: Kukuruyuukk!<br/>";
    }

    public function terbang($jarak = 1, $tinggi = 1)
    {
        if (func_num_args() < 1) {
            echo "Ayam jantan bernama {$this->nama} hanya bisa melompat saja..<br/>";
        } else {
            echo "Ayam jantan bernama {$this->nama} terbang dengan jarak {$jarak} m dan tinggi {$tinggi} m..<br/>";
        }
    }
}
?>