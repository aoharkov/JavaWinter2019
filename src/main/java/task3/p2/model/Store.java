package task3.p2.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private String name;
    private Map<String, Section> sections;

    public Store(String name) {
        this.name = name;
        sections = new HashMap<>();
    }

    public void openSection(String name, int location) {
        if (!sections.containsKey(name)) {
            Section section = new Section(name, location);
            sections.put(name, section);
        } else {
            System.out.println("Exception: such name is taken by another section of the store");
        }
    }

    public Section getSectionByName(String name) {
        if (sections.containsKey(name)) {
            return sections.get(name);
        } else {
            System.out.println("Exception: there is no section with such name as " + name);
            return null;
        }
    }

    public void moveFromToSection(String sectionFrom, String sectionTo, ProductPack[] freight) {
        getSectionByName(sectionFrom).take(freight);
        getSectionByName(sectionTo).deliver(freight);
    }


    public void merge(String sectionOfPurchaser, String sectionOfTarget) {
        getSectionByName(sectionOfPurchaser).deliver(getSectionByName(sectionOfTarget).getStorage());
        closeSection(sectionOfTarget);
    }

    public void closeSection(String name) {
        if (sections.containsKey(name)) {
            sections.remove(name);
        } else {
            System.out.println("Exception: there is no section with such name as " + name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(name);
        str.append(":\n");
        for (Section section :
                sections.values()) {
            str.append(section);
            str.append("\n");
        }
        return str.toString();
    }

    public void sortByQuery(SortTypes sortType) {
        for (Section section :
                sections.values()) {
            section.sortByQuery(sortType);
        }
    }


    public class Section {
        private String name;
        private int location;
        private ProductPack[] storage;

        public Section(String name, int location) {
            this.name = name;
            this.location = location;
            storage = new ProductPack[0];
        }

        public void take(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                int pos = find(productPack);
                if (pos > -1) {
                    storage[find(productPack)].takeQuantity(productPack.getQuantity());
                } else {
                    System.out.println("Exception: not enough products left to take");
                }
            }
        }

        public void deliver(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                int pos = find(productPack);
                if (pos > -1) {
                    storage[find(productPack)].addQuantity(productPack.getQuantity());
                } else {
                    addNewTypeOfProducts(productPack);
                }
            }
        }

        private void addNewTypeOfProducts(ProductPack productPack) {
            storage = Arrays.copyOf(storage, storage.length + 1);
            storage[storage.length - 1] = productPack;
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

        public void sortByQuery(SortTypes sortType) {
            switch (sortType) {
                case QUANTITY:
                    sortByQuantity();
                    break;
                case PRICE:
                    sortByPrice();
                    break;
                case NAME:
                    sortByName();
                    break;
            }
        }

        private void sortByQuantity() {
            Arrays.sort(storage, new Comparator<ProductPack>() {
                @Override
                public int compare(ProductPack o1, ProductPack o2) {
                    return o2.getQuantity() - o1.getQuantity();
                }
            });
        }

        private void sortByPrice() {
            Arrays.sort(storage, new Comparator<ProductPack>() {
                @Override
                public int compare(ProductPack o1, ProductPack o2) {
                    return o2.getProduct().getPrice() - o1.getProduct().getPrice();
                }
            });
        }

        private void sortByName() {
            Arrays.sort(storage, new Comparator<ProductPack>() {
                @Override
                public int compare(ProductPack o1, ProductPack o2) {
                    return o1.getProduct().getName().compareTo(o2.getProduct().getName());
                }
            });
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
