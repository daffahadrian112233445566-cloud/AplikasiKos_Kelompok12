import java.util.Date

/**
 * Class User
 * Merepresentasikan data pengguna sistem (Kasir maupun Admin).
 * Enkapsulasi diterapkan pada atribut "username":
 * tidak boleh kosong dan tidak boleh mengandung spasi.
 */
class User(
    val userId: String,
    var nama: String,
    username: String,
    var role: String
) {
    var username: String = username
        private set

    fun setUsername(newUsername: String) {
        require(newUsername.isNotBlank()) { "Username tidak boleh kosong." }
        require(!newUsername.contains(" ")) { "Username tidak boleh mengandung spasi." }
        username = newUsername
    }

    fun login(): Boolean {
        // Logika autentikasi keamanan
        println("$nama ($role) berhasil login.")
        return true
    }

    fun updateProfil() {
        println("Profil $nama berhasil diperbarui.")
    }
}

/**
 * Class Produk
 * Merepresentasikan data katalog barang.
 * Enkapsulasi diterapkan pada atribut "stok":
 * tidak boleh diisi nilai negatif (validasi stok barang).
 */
class Produk(
    val productId: String,
    var namaProduk: String,
    var harga: Int,
    stok: Int
) {
    var stok: Int = stok
        private set

    fun setStok(jumlah: Int) {
        require(jumlah >= 0) { "Stok tidak boleh bernilai negatif." }
        stok = jumlah
    }

    fun cekStok(): Int {
        return stok
    }

    fun updateStok(jumlah: Int) {
        val stokBaru = stok + jumlah
        require(stokBaru >= 0) { "Update stok gagal: hasil akhir tidak boleh negatif." }
        stok = stokBaru
    }
}

/**
 * Class Transaksi
 * Menghubungkan User (Kasir) dengan Produk dalam satu riwayat transaksi.
 */
class Transaksi(
    val transaksiId: String,
    val tanggal: Date,
    var totalHarga: Int
) {
    fun buatTransaksi() {
        println("Transaksi $transaksiId berhasil dibuat dengan total Rp$totalHarga.")
    }

    fun cetakStruk() {
        println("=== STRUK TRANSAKSI ===")
        println("ID Transaksi : $transaksiId")
        println("Tanggal      : $tanggal")
        println("Total Harga  : Rp$totalHarga")
        println("=======================")
    }
}
