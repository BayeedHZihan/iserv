<?php


$host = "localhost";
$user = "iservhom_iserve";
$password = "iserve";
$db = "iservhom_iserve";

$restname = $_POST["restname"];

$sql = "select sub from submenu where restname like '$restname';";


$con = mysqli_connect($host,$user,$password,$db);

$result = mysqli_query($con,$sql);
$response = array();

while($row = mysqli_fetch_array($result))
{

array_push($response,array("restname"=>$row[0]));


}

echo json_encode(array("server_respone"=>$response));

mysqli_close($con);





?>