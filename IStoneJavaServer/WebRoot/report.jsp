<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>IStone管理员系统</title>
	<link rel="stylesheet" href="css/videoView.css">
	<link rel="stylesheet" href="css/report.css">
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
            <li id="current"><a href="report.jsp" role="tab" data-toggle="tab">举报管理</a></li>
            <li><a href="music.jsp" role="tab" data-toggle="tab">背景音乐管理</a></li>
            <li><a href="label.jsp" role="tab" data-toggle="tab">标签管理</a></li>
   
        </ul>
	</div>
	<div class="details">
		<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 举报清单列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="checkbox" name="checkbox11" id="checkbox11" />
              全选      &nbsp;&nbsp; <img src="images/del.gif" width="10" height="10" /> 删除    &nbsp;&nbsp;<img src="images/edit.gif" width="10" height="10" /> 查看  &nbsp;</span><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" />
        </div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">举报人ID</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">被举报人ID</span></div></td>
        <td width="16%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">被举报人昵称</span></div></td>
        <td width="27%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">举报原因</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox2" id="checkbox2" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">A0001</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">4616846</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">1354158</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">DBserver</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">视频内容不符合要求</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox3" id="checkbox3" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0002</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">646126516</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">139132548</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">小梨子的小苹果</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">视频女主角我不喜欢</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox4" id="checkbox4" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0003</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">39739793</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">116812548</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">小李子给大爷请安</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">内容枯燥没有新意.</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox5" id="checkbox5" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0004</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">752427237</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13914248</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">我是昵称</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">不喜欢视频拍摄者</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox6" id="checkbox6" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0005</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">624757545</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">139752732</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">小李子</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">视频男主不是我.</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox7" id="checkbox7" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0006</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">1614642465</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">13913612548</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">视圈达人</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">心情不好</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox8" id="checkbox8" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0007</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">41648432464</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">1416812548</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">棒棒冰</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">这是小广告.</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox9" id="checkbox9" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0008</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">421641986</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">41695548</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">傲娇的小馒头</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">总是该需求.心好累</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input type="checkbox" name="checkbox10" id="checkbox10" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">A0009</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">456246167</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">1146849886</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">我承包了鱼塘</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">不看着不舒服.</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="#">删除</a> | <a href="#">查看</a></span></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> 243</strong> 条记录，当前第<strong> 1</strong> 页，共 <strong>10</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
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
                </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
	</div>
</body>
</html>
            