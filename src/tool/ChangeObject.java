package tool;

import java.lang.reflect.Field;

/*
 * ͨ��java������ƣ��ı�old-new ����ֵ
 * ps: new ĳһ����Ϊ�ղ��䣬new value not null And (old value!=new value or old value is null) change old value
 *           --by ����
 * */
public class ChangeObject {

    private Object newObj;
    private Object oldObj;

    public ChangeObject(Object newOb, Object oldOb) {
        this.newObj = newOb;
        this.oldObj = oldOb;
    }

    public void change() {
        Field[] fields = newObj.getClass().getDeclaredFields();

        for (Field field : fields) {
            String type = field.getType().getSimpleName();
            if (type.equals("int")) {
                field.setAccessible(true);
                try {
                    if (0 != (int) field.get(newObj)) {
                        field.set(oldObj, field.get(newObj));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("String") || type.equals("date")) {
                field.setAccessible(true);
                try {
                    if (null != field.get(newObj) && !field.get(newObj).equals(field.get(oldObj))) {
                        field.set(oldObj, field.get(newObj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
