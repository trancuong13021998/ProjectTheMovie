<?php
	require "connect.php";
	$query = "SELECT * FROM movie";
	$data = mysqli_query($conn,$query);
		$arrmovie = array();
	class Movies{
		function __construct($id ,$moviename,$movieduration,$description,$imgmovie){
			$this->id  = $id ;
			$this->moviename = $moviename;
			$this->movieduration = $movieduration;
			$this->description = $description;
			$this->imgmovie = $imgmovie;
		}
	}
	while ( $row = mysqli_fetch_assoc($data)) {
			array_push($arrmovie, new Movies(
				$row['id'],
				$row['moviename'],
				$row['movieduration'],
				$row['description'],
				$row['imgmovie']));

	}

	 echo json_encode($arrmovie);
	
  ?>