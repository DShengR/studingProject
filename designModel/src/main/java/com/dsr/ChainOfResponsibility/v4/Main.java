package com.dsr.ChainOfResponsibility.v4;

/**
 * Created by duansr on 2020/8/24.
 * 请求发送到链上，如果当前处理者，能处理则处理，如果不能处理则传递给下一个处理者
 * 员工请假，请假一天，小组长直接处理，请假两天小组长不能处理转交给项目经理处理，请假3天项目经理也处理不了，转给部门经理
 */
public class Main {
    public static void main(String[] args){
        Staff staff=new Staff();
        staff.setType("请假");
        staff.setDays(1);
        LeaveHandler group=new GroupManHandler(1);
        LeaveHandler project=new ProjectManHandler(2);
        LeaveHandler dept=new DeptManHandler(3);
        group.setNextHandler(project);
        project.setNextHandler(dept);
        group.execute(staff);

    }
}
class Staff{
    private String type;
    private int days;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
}
abstract class  LeaveHandler{
    protected LeaveHandler nextHandler;
    private int level;
    public LeaveHandler(int level){
        this.level=level;
    }
    public LeaveHandler getNextHandler() {
        return nextHandler;
    }
    public void setNextHandler(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public boolean execute(Staff staff){
        if(this.level>=staff.getDays()){
            handler(staff);
        }else{
            nextHandler.execute(staff);
        }
        return true;
    }
    public abstract void handler(Staff staff);
}
class GroupManHandler extends LeaveHandler{
    public GroupManHandler(int level) {
        super(level);
    }
    @Override
    public void handler(Staff staff) {
        System.out.println("小组长同意员工请假");
    }
}
class ProjectManHandler extends LeaveHandler{
    public ProjectManHandler(int level) {
        super(level);
    }
    @Override
    public void handler(Staff staff) {
        System.out.println("项目经理同意员工请假");
    }
}
class DeptManHandler extends  LeaveHandler{
    public DeptManHandler(int level) {
        super(level);
    }
    @Override
    public void handler(Staff staff) {
         System.out.println("部门经理同意员工请假");
    }
}