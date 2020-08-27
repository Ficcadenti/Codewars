<?php
	function invert(array $a): array {
		$stack = array();
		foreach ($a as $value)
			array_push($stack, -$value);
		return $stack;
	}
?>