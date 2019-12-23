package task3.p2.model;

import java.util.Arrays;
import java.util.Comparator;

public class Store {
    private String name;
    private Section[] sections;

    public Store(String name) {
        this.name = name;
        sections = new Section[0];
    }

    public void openSection(String name, int location) {
        Section section = new Section(name, location);
        sections = Arrays.copyOf(sections, sections.length + 1);
        sections[sections.length - 1] = section;
    }

    public void moveFromToSection(Section sectionFrom, Section sectionTo, ProductPack[] freight) {
        sectionFrom.take(freight);
        sectionTo.deliver(freight);
    }

    public void merge(Section sectionOfPurchaser, Section sectionOfTarget) {
        sectionOfPurchaser.deliver(sectionOfTarget.getStorage());
        closeSection(sectionOfTarget);
    }

    public void closeSection(Section section) {
        if (sections.length > 1) {
            sections[find(section)] = sections[sections.length - 1];
            sections = Arrays.copyOf(sections, sections.length - 1);
        } else {
            sections = new Section[0];
        }
    }

    private int find(Section section) {
        class NameComparator implements Comparator<Section> {
            @Override
            public int compare(Section o1, Section o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        NameComparator comparator = new NameComparator();
        Arrays.sort(sections, comparator);
        return Arrays.binarySearch(sections, section, comparator);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }

    public class Section {
        private String name;
        private int location;
        private ProductPack[] storage;

        public Section(String name, int location) {
            this.name = name;
            this.location = location;
        }

        public void take(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                storage[find(productPack)].takeQuantity(productPack.getQuantity());
            }
        }

        public void deliver(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                storage[find(productPack)].addQuantity(productPack.getQuantity());
            }
        }

        private int find(ProductPack productPack) {
            class NameComparator implements Comparator<ProductPack> {
                @Override
                public int compare(ProductPack o1, ProductPack o2) {
                    return o1.getProduct().getName().compareTo(o2.getProduct().getName());
                }
            }
            NameComparator comparator = new NameComparator();
            Arrays.sort(storage, comparator);
            return Arrays.binarySearch(storage, productPack, comparator);
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder(storage.length * 16);
            str.append(name);
            str.append(":\n");
            for (ProductPack productPack :
                    storage) {
                str.append(productPack);
                str.append("\n");
            }
            return str.toString();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public ProductPack[] getStorage() {
            return storage;
        }

        public void setStorage(ProductPack[] storage) {
            this.storage = storage;
        }
    }
}
