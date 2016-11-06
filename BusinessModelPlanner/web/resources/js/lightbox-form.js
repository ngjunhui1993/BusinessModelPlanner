

function gradient(id, level)
{
	var box = document.getElementById(id);
	box.style.opacity = level;
	box.style.MozOpacity = level;
	box.style.KhtmlOpacity = level;
	box.style.filter = "alpha(opacity=" + level * 100 + ")";
	box.style.display="block";
	return;
}


function fadein(id) 
{
	var level = 0;
	while(level <= 1)
	{
		setTimeout( "gradient('" + id + "'," + level + ")", (level* 1000) + 10);
		level += 0.01;
	}
}


// Open the lightbox


function openStep1Box(fadin)
{
  var box = document.getElementById('step1');
  document.getElementById('shadowing').style.display='block';
  
  if(fadin)
  {
	 gradient("step1", 0);
	 fadein("step1");
  }
  else
  { 	
    box.style.display='block';
  }  	
}

function openLoadProjectBox(fadin)
{
  var box = document.getElementById('loadProject');
  document.getElementById('shadowing').style.display='block';
  
  if(fadin)
  {
	 gradient("loadProject", 0);
	 fadein("loadProject");
  }
  else
  { 	
    box.style.display='block';
  }  	
}


function openEditProductBox(fadin)
{
  var box = document.getElementById('editProduct');
  document.getElementById('shadowing').style.display='block';


  
  if(fadin)
  {
	 gradient("editProduct", 0);
	 fadein("editProduct");
  }
  else
  { 	
    box.style.display='block';
  }  	
}

function openEditOperator1(operator, fadin)
{
  var box = document.getElementById('editOperator1');
  document.getElementById('shadowing').style.display='block';
  var operatorNum = document.getElementById('operator1');
  operatorNum.innerHTML = operator;
  
  if(fadin)
  {
	 gradient("editOperator1", 0);
	 fadein("editOperator1");
  }
  else
  { 	
    box.style.display='block';
  }
}

function openEditOperator2(operator, fadin)
{
  var box = document.getElementById('editOperator2');
  document.getElementById('shadowing').style.display='block';
  var operatorNum = document.getElementById('operator2');
  operatorNum.innerHTML = operator;
  
  if(fadin)
  {
	 gradient("editOperator2", 0);
	 fadein("editOperator2");
  }
  else
  { 	
    box.style.display='block';
  }
}

function openEditOperator3(operator, fadin)
{
  var box = document.getElementById('editOperator3');
  document.getElementById('shadowing').style.display='block';
  var operatorNum = document.getElementById('operator3');
  operatorNum.innerHTML = operator;
  if(fadin)
  {
	 gradient("editOperator3", 0);
	 fadein("editOperator3");
  }
  else
  { 	
    box.style.display='block';
  }
}

function openEditOperator4(operator, fadin)
{
  var box = document.getElementById('editOperator4');
  document.getElementById('shadowing').style.display='block';
    var operatorNum = document.getElementById('operator4');
  operatorNum.innerHTML = operator;
  if(fadin)
  {
	 gradient("editOperator4", 0);
	 fadein("editOperator4");
  }
  else
  { 	
    box.style.display='block';
  }
}

function openAddOperatorBox(fadin)
{
  var box = document.getElementById('addOperator');
  document.getElementById('shadowing').style.display='block';
  
  if(fadin)
  {
	 gradient("addOperator", 0);
	 fadein("addOperator");
  }
  else
  { 	
    box.style.display='block';
  }  	
}


// Close the lightbox

function closebox()
{
   document.getElementById('addOperator').style.display='none';
   document.getElementById('loadProject').style.display='none';
   document.getElementById('step1').style.display='none';
   document.getElementById('editProduct').style.display='none';
   document.getElementById('shadowing').style.display='none';
}


function closeOpBox1()
{
   document.getElementById('editOperator1').style.display='none';
   document.getElementById('shadowing').style.display='none';
}

function closeOpBox2()
{
   document.getElementById('editOperator2').style.display='none';
   document.getElementById('shadowing').style.display='none';
}

function closeOpBox3()
{
   document.getElementById('editOperator3').style.display='none';
   document.getElementById('shadowing').style.display='none';
}

function closeOpBox4()
{
   document.getElementById('editOperator4').style.display='none';
   document.getElementById('shadowing').style.display='none';
}

function delete4(){
    var check = document.getElementById('delete4');
    check.innerHTML = "true";
}


