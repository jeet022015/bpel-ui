<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
  
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="en-GB" />
    <meta name="author" content="Your Name" />
    <meta name="abstract" content="A one-liner describing your site." />
    <meta name="description" content="A longer description of your site." />
    <meta name="keywords" content="some, words, characterising, your, web, site" />
    <meta name="distribution" content="global" />
    <meta name="revisit-after" content="1 days" />	
    <meta name="copyright" content="All content (c) Your Name" />
    
    <title>UI-BPEL</title>
    
    <style type="text/css" title="The shiny, Web 2.0 version of 'Simplicity,' a pseudo-professional style-sheet." media="all">
      @import "/BrowserAppClient/beaty2/layout/simplicity-two-oh-three.css";
    </style>
    <!--[if IE]>
    <style type="text/css" media="all">
      @import "layout/ie-diff.css";
    </style> 
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="layout/print.css" media="print" />
    <link rel="shortcut icon" href="http://wherever-your-favicon-is.org/favicon.png"  />
    <link rel="icon" href="http://wherever-your-favicon-is.org/favicon.png" />
    
  </head>
  
  <body>
    
    <div id="window">
      <div id="container">
	
	<div id="navigation">
	  <ul>
	    <!-- The link you call "active" will show up as a darker tab -->
	    <!--[if IE 6]><li></li><![endif]-->
	    <li class="active"><span>User Interaction</span></li>
	    <li><a href="index.html">Status</a></li>
	  </ul>
	</div>
	
	<div id="main">
	  <div id="outer-prettification">
	    <div id="inner-prettification">
	      
	      <div id="header">
		<h1 id="title"><a href="index.html">Please, provide the following information.</a></h1>
	      </div>
	      
	      <div id="contents">
			<form action='/BrowserAppClient/InputUiController' method="get">
				<ol>
					<h2>Personal information</h2>
			        <li>
			        	<label for="name">Name</label>
			        	<input id="element" type="text" name="name" id="name" /><br/>
			        	<label for="address">Address</label>
			        	<input id="element" type="text" name="address" id="address" /><br/>
			        	<label for="zip">Zip</label>
			        	<input id="element" type="text" name="zip" id="zip" /><br/>
			        	<label for="product">Product</label>
			        	<input id="element" type="text" name="product" id="product" />
			        </li>
			        <li id="send">
			        	<button type="submit">Input</button>
			        </li>
			    </ol>
			</form>
	      </div>

              <div id="footer">
		<p><a href="index.html" title="Perhaps link to your copyright notice?">UI-BPEL 0.5</a></p>
		<!-- You can do whatever you like here -->
	      </div>
	      
	    </div>
	  </div>
	</div>

      </div>
    </div>

  </body>

</html>
