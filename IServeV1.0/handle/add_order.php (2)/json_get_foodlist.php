<?php


$host = "localhost";
$user = "iservhom_iserve";
$password = "iserve";
$db = "iservhom_iserve";


$restname = $_POST["restname"];
$sub=$_POST["sub"];

$sql = "select food,price from foodmenu where restname like '$restname' and sub like '$sub';";


$con = mysqli_connect($host,$user,$password,$db);

$result = mysqli_query($con,$sql);
$response = array();

while($row = mysqli_fetch_array($result))
{

array_push($response,array("restname"=>$row[0], "price"=>$row[1]));



}

echo json_encode(array("server_respone"=>$response));

mysqli_close($con);





?>