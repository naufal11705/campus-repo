<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP OOP</title>
</head>
<body>
    <h1>Demo Kelas Burung</h1>
    <div>
        <?php
        require_once 'classes/EntitasTerbang.php';
        require_once 'classes/Burung.php';

        use classes\Burung;

        $burung = new Burung("Pipit", 2);

        echo "<p>" . $burung->terbang() . "</p>";
        echo "<p>" . $burung->bersuara() . "</p>";
        ?>
    </div>
</body>
</html>
