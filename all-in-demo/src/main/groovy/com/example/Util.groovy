package com.example

import   java.util.List
import java.util.*

class Util  {
	static String format(  String name  )  {
		"Util:" + name
	}

	static List<String>  upper(List<String> list)  {
		list.collect{   it.toUpperCase()   }
	}
}
