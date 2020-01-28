package task.task3.p2.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Store {
    private static final Logger LOGGER = LogManager.getLogger(Store.class);
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
            LOGGER.error("Exception: such name is taken by another section of the store");
        }
    }

    public Section getSectionByName(String name) {
        if (sections.containsKey(name)) {
            return sections.get(name);
        } else {
            LOGGER.error(String.format("Exception: there is no section with such name as %s", name));
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

    private void closeSection(String name) {
        if (sections.containsKey(name)) {
            sections.remove(name);
        } else {
            LOGGER.error(String.format("Exception: there is no section with such name as %s", name));
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

        Section(String name, int location) {
            this.name = name;
            this.location = location;
            storage = new ProductPack[0];
        }

        public void take(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                int pos = find(productPack);
                if (pos > -1) {
                    storage[pos].takeQuantity(productPack.getQuantity());
                    if (storage[pos].getQuantity() == 0) {
                        deleteEmptyProductPack(pos);
                    }
                } else {
                    LOGGER.error("Exception: not enough products left to take");
                }
            }
        }

        private void deleteEmptyProductPack(int pos) {
            if (pos == storage.length - 1) {
                storage = Arrays.copyOf(storage, storage.length - 1);
            } else {

                if (storage.length - 1 - pos >= 0)
                    System.arraycopy(storage, pos + 1, storage, pos, storage.length - 1 - pos);
            }
        }

        public void deliver(ProductPack[] freight) {
            for (ProductPack productPack :
                    freight) {
                int pos = find(productPack);
                if (pos > -1) {
                    storage[pos].addQuantity(productPack.getQuantity());
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

        void sortByQuery(SortTypes sortType) {
            switch (sortType) {
                case QUANTITY:
                    sortByQuantity();
                    break;
                case PRICE:
                    sortByPrice();
                    break;
                default:
                    sortByName();
                    break;
            }
        }

        private void sortByQuantity() {
            Arrays.sort(storage, (o1, o2) -> o2.getQuantity() - o1.getQuantity());
        }

        private void sortByPrice() {
            Arrays.sort(storage, (o1, o2) -> o2.getProduct().getPrice() - o1.getProduct().getPrice());
        }

        private void sortByName() {
            Arrays.sort(storage, (o1, o2) -> o1.getProduct().getName().compareTo(o2.getProduct().getName()));
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

        ProductPack[] getStorage() {
            return storage;
        }

        public void setStorage(ProductPack[] storage) {
            this.storage = storage;
        }
    }
}
