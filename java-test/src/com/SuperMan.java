package com;

/**
 * Created by lawrence on 2016/12/27.
 */
class SuperMan extends Person implements ActionInterface
{
    private boolean BlueBriefs;

    public void fly()
    {
        System.out.println("���˻��Ү����");
    }

    public boolean isBlueBriefs() {
        return BlueBriefs;
    }
    public void setBlueBriefs(boolean blueBriefs) {
        BlueBriefs = blueBriefs;
    }

    @Override
    public void walk(int m) {
        // TODO Auto-generated method stub
        System.out.println("���˻���Ү��������" + m + "�׾��߲����ˣ�");
    }
}
