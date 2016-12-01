package pattern.Prototype;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/11.
 * Time: 0:29
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setId("1");
        person.setName("lzf");

        String [] hobbies = {"music","movie"};
        person.setHobby(hobbies);

        Person person1 = (Person) person.clone();
        System.out.println(person);
        System.out.println(person1);

        System.out.println(person.getHobby());
        System.out.println(person1.getHobby());
    }


    static class Person implements Cloneable {
        private String id;
        private String name;
        private String[] hobby;

        public String[] getHobby() {
            return hobby;
        }

        public void setHobby(String[] hobby) {
            this.hobby = hobby;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //return super.clone();

            Person personClone = (Person)super.clone();
            personClone.setHobby( (String[]) personClone.getHobby().clone());
            return personClone;
        }
    }
}
