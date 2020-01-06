/**
 * 
 */
package util.taglib.base;

import java.io.Serializable;

/**
 * 码表中的所有数据
 * @author desert
 * @version 1.0
 */
public class CodeTableValue implements Serializable{

	private static final long serialVersionUID = 1L;
	//性别
	public static final String[] XB_LIST ={"男","女","未知"};
	//民族
    public static final String[] ZGMZ_LIST={"汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族","哈尼族","哈萨克族","傣族","黎族","傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛难族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族","乌孜别克族","俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族","穿青人族","其他"};
    //课时
    public static final String[] KS_LIST ={"1","2","3","4","5","6","7","8"};
    //政治面貌
    public static final String[] ZZMM_LIST = {"中国共产党党员","中国共产党预备党员","中国共产主义青年团团员","中国国民党革命委员会会员","中国民主同盟盟员","中国民主建国会会员","中国民主促进会会员","中国农工民主党党员","中国致公党党员","九三学社社员","台湾民主自治同盟盟员","无党派民主人士","群众"};
    //学历
    public static final String[] XL_LIST = {"研究生教育","博士研究生毕业","博士研究生结业","博士研究生肄业","硕士研究生毕业","硕士研究生结业","硕士研究生肄业","研究生班毕业","研究生班结业","研究生班肄业","大学本科","大学本科毕业","大学本科结业","大学本科肄业","大学普通班毕业","专科教育","大学专科毕业","大学专科结业","大学专科肄业","中等职业教育","中等专科毕业","中等专科结业","中等专科肄业","职业高中毕业","职业高中结业","职业高中肄业","技工学校毕业","技工学校结业","技工学校肄业","普通高级中学教育","普通高中毕业","普通高中结业","普通高中肄业","初级中学教育","初中毕业","初中肄业","小学教育","小学毕业","小学肄业","其他"};
    //学位
    public static final String[] XW_LIST = {"学士学位","硕士学位","博士学位"};
    //评价
    public static final String[] EVAL_LEVEL ={"非常满意","满意","无意见","不满意","非常不满意"};
    //默认评价级别对应分数数组
    public static final String[] EVAL_SCORE ={"5","4","3","2","1"};
    
    //婚姻状况
    public static final String[] HYZK_LIST ={"未婚","已婚","初婚","再婚","复婚","丧偶","离婚","未说明的婚姻状况"};
    //健康状况[一位数]
    public static final String[] JKONE_LIST = {"健康或良好","一般或较弱","有慢性病","残疾"};
    //从业情况
    public static final String[] CYQK_LIST = {"国家公务员","专业技术人员","职员","企业管理人员","工人","农民","学生","现役军人","自由职业者","个体经营者","无业人员","退（离）休人员","其他"};
    //干部职务
    public static final String[] GBZW_LIST = {"国家主席、副主席、总理级","副总理、国务委员级","部、省级","副部、副省级","司、局、地、厅级","副司、副局、副地、副厅级","县、处级","副县、副处级","正科级","副科级","科员级","办事员级"};
    //教职工当前状态
    public static final String[] ZGZT_LIST = {"在职","离职","退休","其他"};
    //宗教信仰
    public static final String[] ZJXY_LIST={"无宗教信仰","佛教","喇嘛教","道教","天主教","基督教","东正教","伊斯兰教","其他"};
    //户口类别
    public static final String[] HKLB_LIST={"未落常住户口","非农业家庭户口","农业家庭户口","非农业集体户口","农业集体户口","自理口粮户口","寄住户口","暂住户口","其他户口"};
    //职务级别
    public static final String[] ZWJB_LIST = {"公务员职务级别","国家级正职","国家级副职","省部级正职","省部级副职","厅局级正职","厅局级副职","县处级正职","县处级副职","乡科级正职","乡科级副职","科员级","办事员级","未定职公务员","职员级别","一级职员","二级职员","三级职员","四级职员","五级职员","六级职员","七级职员","八级职员","九级职员","十级职员","为定级职员","专业技术职务级别","高级","正高级","副高级","中级","初级","助理级","员级","未定职级专业技术人员"};
    //职务变动类别 
    public static final String[] ZWBD_LIST = {"新定职","按期逐级晋升","提前逐级晋升","越一级晋升","越二级及二级以上晋升","未免原职务、晋升新职务","同职连任","延长任职","平级增职","向下兼职","评级调任","保留原级别职务","挂职","平级转任","免减兼职","全免现职","免去挂职","降一级任职","降二级任职","降三级任职","其他"};
    //免职方式 
    public static final String[] MZFS_LIST = {"落选","解聘","罢免","届满","其他"};
    //任职方式
    public static final String[] RZFS_LIST = {"党委(党组)决定任职","行政命令任职","会议选举任职","聘用任职","考试录用任职","其他"};
    //当前任职状态 
    public static final String[] RZZT_LIST = {"不在任","在任"};
    //政治面貌异常类别
    public static final String[] ZZYC_LIST = {"入团转党","重新入党","延期转正","未予登记","暂缓登记","自动脱党","除名","取消预备党员资格","开除党籍","其他"};
    //血型
    public static final String[] XX_LIST = {"未知血型","A血型","B血型","AB血型","O血型","RH阳性血型","RH阴性血型","HLA血型","未定血型","其他血型"};
    //聘用方式
    public static final String[] PYFS_LIST = {"合同工","正式聘用","外聘人员","行业人员","兼职人员"};
 }