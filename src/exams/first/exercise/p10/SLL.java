package exams.first.exercise.p10;

class SLL {
    class SLLNode {
        protected int id;
        protected int plata;
        protected SLLNode succ;

        public SLLNode(int id,int plata, SLLNode succ) {
            this.id = id;
            this.plata = plata;
            this.succ = succ;
        }


    }

    private SLLNode first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }


    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id,plata, first);
        first = ins;
    }

    public void insertLast(int id,int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id,plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }


    public SLL brisi_pomali_od(int iznos) {
        // Vasiot kod tuka
        SLL sll = new SLL();
        SLLNode temp = this.getFirst();
        while (temp != null) {
            if (temp.plata >= iznos) {
                sll.insertLast(temp.id, temp.plata);
            }
            temp = temp.succ;
        }
        return sll;
    }

    public SLL sortiraj_opagacki() {
        // Vasiot kod tuka
        SLLNode temp = this.getFirst();
        boolean flag = true;
        if( temp != null) {
            while (flag) {
                flag = false;
                SLLNode temp1 = this.getFirst();
                while (temp1.succ != null) {
                    if (temp1.id < temp1.succ.id) {
                        int tempSwap;
                        tempSwap = temp1.id;
                        temp1.id = temp1.succ.id;
                        temp1.succ.id = tempSwap;
                        tempSwap = temp1.plata;
                        temp1.plata = temp1.succ.plata;
                        temp1.succ.plata = tempSwap;
                        flag = true;
                    }
                    temp1 = temp1.succ;
                }
                temp = temp.succ;
            }
        }
        return this;
    }
    public void pecati (SLL lista) {
        SLLNode p=lista.first;
        if (p != null) {
            while(p!=null)
            {
                System.out.println(p.id+" "+p.plata);
                p=p.succ;
            }
        }else {
            System.out.println("nema");
        }

    }

}