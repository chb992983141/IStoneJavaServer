<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>IStone管理员系统</title>
	<link rel="stylesheet" href="css/videoView.css">
	<link rel="stylesheet" href="css/music.css">
</head>
<body>
	<div class="header"></div>
	<div class="login">
		<h2>IStone管理员系统</h2>
		<div id="manaInfo">
			<ul>
				<li><a href="#">管理员信息</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
	</div>
	<div class="menu">
		<ul >
            <li ><a href="videoView.jsp" role="tab" data-toggle="tab">视频管理</a></li>
            <li ><a href="information.jsp" role="tab" data-toggle="tab">信息管理</a></li>
            <li><a href="report.jsp" role="tab" data-toggle="tab">举报管理</a></li>
            <li id="current"><a href="music.jsp" role="tab" data-toggle="tab">背景音乐管理</a></li>
            <li><a href="label.jsp" role="tab" data-toggle="tab">标签管理</a></li>
   
        </ul>
	</div>

	<div id="container">
        <div id="musicPublish">
        <div class="details">
        	<input type="text" placeholder=" 背景音乐名称"><br>
        	 <input type="text" placeholder=" 背景音乐ID"><br>
        	 <input type="file">
        	 <textarea name="details" id="textraea" placeholder=" 背景音乐简介" cols="35" rows="10"></textarea>
        </div>
        </div>
    <div class="choosen">
        <input type="submit" value=" " class="button">
    </div>

    <div class="left">
    	<table width="105%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="40" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="30" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">背景音乐列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="checkbox" name="checkbox11" id="checkbox11" />
              全选      &nbsp;&nbsp; <img src="images/del.gif" width="10" height="15" /> 删除    &nbsp;&nbsp;</span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="30" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" />
        </div></td>
        <td width="10%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">背景音乐名称</span></div></td>
        <td width="15%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">背景音乐ID</span></div></td>
        <td width="27%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">详细描述</span></div></td>
        <td width="14%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox2" id="checkbox2" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">Stay</span></div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">24892141</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">动感的旋律配上炫酷的视频，瞬间高大上</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center" class="STYLE21">删除 </div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox3" id="checkbox3" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">What you like </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">7491848923</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">柔美的旋律配上温暖的视频</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox4" id="checkbox4" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">小苹果</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">走在时尚前沿，广场舞也疯狂</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox5" id="checkbox5" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">好日子</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">欢乐的视频怎能没有欢乐的音乐</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox6" id="checkbox6" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">卡农</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">柔美的轻音乐唤醒的不只是温情</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox7" id="checkbox7" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">夜莺</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">经典视频自然要搭配经典音乐</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox8" id="checkbox8" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">demo</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">demodemodemo</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox9" id="checkbox9" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">lostRivers</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">深夜报复社会</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
      <tr>
        <td height="30" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox10" id="checkbox10" />
        </div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">稻香</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">家乡的景依旧这么美丽</div></td>
        <td height="30" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21">删除</span></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> 243</strong> 条记录，当前第<strong> 1</strong> 页，共 <strong>10</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
           <td width="62" height="22" valign="middle"><div align="right"><img src="images/first.gif" width="37" height="15" /></div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><img src="images/back.gif" width="43" height="15" /></div></td>
                  <td width="54" height="22" valign="middle"><div align="right"><img src="images/next.gif" width="43" height="15" /></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><img src="images/last.gif" width="37" height="15" /></div></td>
                  <td width="59" height="22" valign="middle"><div align="right">第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td>
                  <td width="30" height="22" valign="middle"><img src="images/go.gif" width="37" height="15" /></td>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
    </div>
</body>
</html>
             