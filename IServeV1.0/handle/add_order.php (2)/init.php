<?php

$host = "localhost";
$db_name="iservhom_iserve";
$mysql_user="iservhom_iserve";
$mysql_pass="iserve";
$server_name="localhost";

$con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);
if(!$con)
{
echo "Connection Error".mysqli_connect_error();}
else
{
echo " <br><h3>Connection Success... </h3>;
";}
?>