<?php 
	require "init.php";
	 $customer_name=$_POST["customer_name"];
	 
	 $customer_address=$_POST["customer_address"];
	 $customer_phone=$_POST["customer_phone"];
         $ordertypefinal1=$_POST["ordertypefinal1"];
         $detail=$_POST["detail"];
         $totalprice=$_POST["totalprice"];
         $region=$_POST["region"];
         $status=$_POST["status"];
         $date=$_POST["date"];
         $imei=$_POST["imei"];
         $called="n";


	$sql = "insert into customer_order (customer_name,customer_address,customer_phone,ordertypefinal1,detail,totalprice,region,status,date,imei,called) values ('$customer_name','$customer_address','$customer_phone','$ordertypefinal1','$detail','$totalprice','$region','$status','$date','$imei','$called');";

	if(mysqli_query($con,$sql)){
		echo "<br><h3>One Row Inserted...</h3>";
	} 

	else {
		echo "Error in insertion ...". mysqli_error($con);
	}
?>