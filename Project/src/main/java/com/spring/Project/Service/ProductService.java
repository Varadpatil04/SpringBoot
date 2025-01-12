package com.spring.Project.Service;

import com.spring.Project.Model.Product;
import com.spring.Project.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts() {
        return repo.findAll();
    }


    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getName());
        product.setInmageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }


    public Product updateProduct(int id, Product updatedProduct, MultipartFile imageFile) throws IOException {
        // Fetch the existing product
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product with ID " + id + " not found.");
        }

        // Update fields of the existing product
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDecs(updatedProduct.getDecs());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setRelease_date(updatedProduct.getRelease_date());
        existingProduct.setAvailable(updatedProduct.isAvailable());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        // Update image if a new one is provided
        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setInmageType(imageFile.getContentType());
            existingProduct.setImageData(imageFile.getBytes());
        }

        // Save the updated product
        return repo.save(existingProduct);
    }


    public void deleteProd(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProduct(keyword);
    }
}
