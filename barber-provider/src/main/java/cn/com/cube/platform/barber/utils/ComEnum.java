package cn.com.cube.platform.barber.utils;

public class ComEnum {

    public static enum SearchOp{
        eq_("精确查询"),lk_("模糊查询"),b0_("between查询"),b1_("between查询"),gt_("大于"),ge_("大于等于"),lt_("小于"),le_("小于等于");

        private String desc;
        private SearchOp(String desc){
            this.desc=desc;
        }
        public String getDesc(){
            return desc;
        }
        public static SearchOp getOp(String str){
            for(SearchOp item:SearchOp.values()){
                if(str.equalsIgnoreCase(item.toString())){
                    return item;
                }
            }
            return eq_;
        }
    }


    public static void main(String[] args){
        System.out.println(SearchOp.getOp("模糊查询"));
    }



}
