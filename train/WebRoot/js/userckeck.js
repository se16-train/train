function User()
{
	var f=document.form1;
	if(f.userName.value=="")
	{
		alert("���ֲ���Ϊ��");
        f.userName.focus();
        f.userName.select();
		return false;
	}
    if(f.userName.value.substring(0,1)==" ")
     {
        alert("��һλ����Ϊ��");
        f.userName.focus();
        f.userName.select();
        return false;
     }
	if(f.userName.value.length<8)
	{
		alert("�������û����Ȳ���ȷ");
                f.userName.focus();
                f.userName.select();
		return false;
	}
	if(f.userName.value.length>12)
	{
		alert("�������û����Ȳ���ȷ");
                f.userName.focus();
                f.userName.select();
		return false;
	}
        if(f.password.value=="")
        {
               alert("���벻��Ϊ��");
               f.password.focus();
                f.password.select();
		return false;
        }
        if(f.password.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.password.focus();
            f.password.select();
            return false;
         }
       
        if(isNaN(f.password.value)!=true)
        {
                 if(f.password.value.length>12 || f.password.value.length<6)
                {	
                        alert("���볤�Ȳ���ȷ");
                        f.password.focus();
                        f.password.select();
                        return false;

                }
        }
        else
        {
                alert("�������Ϊ����");
                f.password.focus();
                f.password.select();
                return false; 
        }
        if(f.password.value.indexOf("-",0)>=0 || f.password.value.indexOf("+",0)>=0)
         {
            alert("���ܳ���+ - ��");
            f.password.focus();
            f.password.select();
            return false;
         }
        if(f.repassword.value=="")
        {
               alert("���벻��Ϊ��");
               f.repassword.focus();
                f.repassword.select();
		return false;
        }
        if(f.repassword.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.repassword.focus();
            f.repassword.select();
            return false;
         }
        if(f.repassword.value!=f.password.value)
	{
		alert("���벻һ��!");
                f.repassword.focus();
                f.repassword.select();
		return false;
	}
        if(f.realName.value=="")
        {
            alert("��������Ϊ��");
            f.userName.focus();
            f.realName.select();
            return false;
        }
        if(f.realName.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.realName.focus();
            f.realName.select();
            return false;
         }
       
        if(isNaN(f.realName.value))
        {
             if(f.realName.value.length<2 || f.realName.value.length>14)
            {
                alert("�������������������");
                f.realName.focus();
                f.realName.select();
                return false;
            }
         }
        else
        {
                alert("��������Ϊ����");
                f.realName.focus();
                f.realName.select();
                return false;    
        }
        
        if(f.tel.value=="")
        {
            alert("�绰����Ϊ��");
            f.tel.focus();
            f.tel.select();
            return false;
        }
       if(f.tel.value.substring(0,1)==" ")
         {
            alert("��һλ����Ϊ��");
            f.tel.focus();
            f.tel.select();
            return false;
         }
        
        if(isNaN(f.tel.value)!=true)
        {
            if(f.tel.value.length<8 || f.tel.value.length>14)
            {
                alert("�绰���볤�Ȳ���ȷ");
                f.tel.focus();
                f.tel.select();
                return false;
            }
        }
        else
        {
            alert("�绰����Ϊ����");
            f.tel.focus();
            f.tel.select();
            return false;
        }
        if(f.tel.value.indexOf("-",0)>=0 || f.tel.value.indexOf("+",0)>=0)
         {
            alert("���ܳ���+ - ��");
            f.tel.focus();
            f.tel.select();
            return false;
         }
        if(f.email.value=="")
        {
            return true;
        }
        else
        {
            if(f.email.value.substring(0,1)==" ")
             {
                alert("��һλ����Ϊ��");
                f.email.focus();
                f.email.select();
                return false;
             }
            if(f.email.value.indexOf("@",0)==-1)
            {
                            alert("��ַ����,��@����");
                             f.email.focus();
                            f.email.select();
                            return false;
            }	
            if(f.email.value.indexOf(".",0)==-1)
            {
                            alert("��ַ����,��.����");
                            f.email.focus();
                            f.email.select();
                            return false;
            }
        }      
}