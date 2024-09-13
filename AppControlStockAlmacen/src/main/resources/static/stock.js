document.addEventListener('DOMContentLoaded', function () {
    const productForm = document.getElementById('productForm');
    const categoryForm = document.getElementById('categoryForm');
    const productList = document.getElementById('productList');
    const submitButton = document.getElementById('submitButton');
    const searchCategoryInput = document.getElementById('searchCategory');
    const salesChart = document.getElementById('salesChart').getContext('2d');
    let editingProductId = null;

    // Función para obtener todos los productos y mostrarlos
    function loadProducts() {
        fetch('/products')
            .then(response => response.json())
            .then(products => {
                productList.innerHTML = '';
                products.forEach(product => {
                    const div = document.createElement('div');
                    div.className = 'product-item';
                    div.innerHTML = `
                        <span>${product.name} - ${product.description} - ${product.quantity} - ${product.price}</span>
                        <div>
                            <button class="button-edit-button" onclick="editProduct(${product.id})">Editar</button>
                            <button class="button-delete-button" onclick="deleteProduct(${product.id})">
                                <div class="trash">
                                    <div class="top"></div>
                                    <div class="box"></div>
                                    <div class="check">
                                        <svg viewBox="0 0 8 6">
                                            <polyline points="1 3.4 2.71428571 5 7 1"></polyline>
                                        </svg>
                                    </div>
                                </div>
                                <span>Eliminar</span>
                            </button>
                        </div>
                    `;
                    productList.appendChild(div);
                });
            });
    }

    // Función para agregar o editar un producto
    productForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = new FormData(productForm);
        const product = {
            name: formData.get('name'),
            description: formData.get('description'),
            quantity: formData.get('quantity'),
            price: formData.get('price'),
            category: formData.get('category')
        };

        const url = editingProductId ? `/products/${editingProductId}` : '/products';
        const method = editingProductId ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
        }).then(response => response.json())
          .then(() => {
            loadProducts(); // Recargar la lista de productos
            productForm.reset(); // Limpiar el formulario
            submitButton.textContent = 'Agregar Producto'; // Restaurar texto del botón
            editingProductId = null; // Restablecer el ID de edición
        }).catch(error => {
            console.error('Error:', error);
            alert('Ocurrió un error.');
        });
    });

    // Función para eliminar un producto
    window.deleteProduct = function (id) {
        fetch(`/products/${id}`, {
            method: 'DELETE'
        }).then(() => {
            loadProducts(); // Recargar la lista de productos
        }).catch(error => {
            console.error('Error:', error);
            alert('Ocurrió un error al eliminar el producto.');
        });
    };

    // Función para preparar el formulario para editar un producto
    window.editProduct = function (id) {
        fetch(`/products/${id}`)
            .then(response => response.json())
            .then(product => {
                document.getElementById('productId').value = product.id;
                document.getElementById('name').value = product.name;
                document.getElementById('description').value = product.description;
                document.getElementById('quantity').value = product.quantity;
                document.getElementById('price').value = product.price;
                document.getElementById('category').value = product.category;
                submitButton.textContent = 'Actualizar Producto'; // Cambiar texto del botón
                editingProductId = id; // Establecer ID de edición
            });
    };

    // Función para buscar productos por categoría
    categoryForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const category = searchCategoryInput.value;

        fetch(`/sales/average/category/${category}`)
            .then(response => response.json())
            .then(data => {
                const productNames = Object.keys(data);
                const averageSales = Object.values(data);

                // Crear gráfico con Chart.js
                new Chart(salesChart, {
                   type: 'line',
                     data: data,
                     options: {
                       animations: {
                         tension: {
                           duration: 1000,
                           easing: 'linear',
                           from: 1,
                           to: 0,
                           loop: true
                         }
                       },
                    options: {
                        scales: {
                             y: { // defining min and max so hiding the dataset does not change scale range
                               min: 0,
                               max: 100
                             }
                           }
                        }
                    }
                });
            }).catch(error => {
                console.error('Error:', error);
                alert('Ocurrió un error al obtener el promedio de ventas.');
            });
    });

    // Cargar productos al inicio
    loadProducts();
});
