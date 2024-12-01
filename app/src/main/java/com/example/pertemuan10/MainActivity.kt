package com.example.pertemuan10

import Mail
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.MailAdapter
import com.example.pertemuan10.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mailAdapter: MailAdapter
    private lateinit var mailList: List<Mail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi daftar mail dengan banyak data
        mailList = listOf(
            Mail("fefefufu", "Sarapan gratis akan segera dimulai", "20 Oct", "Pemberitahuan: Sarapan gratis akan segera dimulai! Kami mengundang semua tamu untuk bergabung dan menikmati hidangan pagi yang telah disediakan. Silakan menuju area sarapan yang telah ditentukan. Nikmati pilihan menu yang tersedia. Pastikan datang tepat waktu agar dapat menikmati sarapan bersama. Selamat menikmati!"),
            Mail("mail1", "Update Kebijakan Privasi", "18 Oct", "Kami telah memperbarui kebijakan privasi kami untuk memberikan Anda pengalaman yang lebih baik dalam menggunakan layanan kami. Harap luangkan waktu untuk meninjau kebijakan terbaru kami yang tersedia di situs web resmi kami. Dengan ini, kami berharap untuk terus melindungi data Anda dan memberikan layanan yang terbaik."),
            Mail("admin", "Pengingat Pembayaran", "15 Oct", "Pembayaran Anda jatuh tempo dalam 3 hari. Pastikan pembayaran dilakukan tepat waktu untuk menghindari denda keterlambatan. Jika Anda sudah melakukan pembayaran, abaikan pesan ini. Hubungi tim support kami jika membutuhkan bantuan lebih lanjut. Terima kasih atas kerjasama dan pengertiannya."),
            Mail("support", "Akun Anda Telah Diverifikasi", "14 Oct", "Selamat! Akun Anda berhasil diverifikasi. Kini Anda dapat menikmati semua fitur yang tersedia di platform kami. Pastikan untuk menjaga informasi akun Anda tetap aman. Jika Anda memiliki pertanyaan atau membutuhkan bantuan, hubungi layanan pelanggan kami kapan saja. Kami siap membantu."),
            Mail("event", "Undangan Webinar", "12 Oct", "Kami mengundang Anda untuk bergabung dalam webinar kami minggu depan. Topik yang akan dibahas sangat menarik dan relevan untuk pengembangan keterampilan Anda. Daftarkan diri Anda segera melalui tautan yang disediakan sebelum tempat habis. Jangan lewatkan kesempatan untuk belajar bersama pakar industri."),
            Mail("newsletter", "Berita Terbaru Minggu Ini", "10 Oct", "Dapatkan berita terbaru dan informasi mingguan dari kami langsung di kotak masuk Anda. Jangan lewatkan artikel-artikel menarik yang telah kami siapkan khusus untuk Anda. Kami berkomitmen memberikan informasi yang bermanfaat setiap minggunya. Pastikan tetap berlangganan untuk berita terbaru."),
            Mail("jobportal", "Peluang Karir Baru", "8 Oct", "Kami memiliki beberapa peluang karir baru yang mungkin menarik bagi Anda. Kunjungi portal karir kami untuk menemukan posisi yang sesuai dengan keahlian dan minat Anda. Jangan lewatkan kesempatan emas ini untuk bergabung dengan tim kami dan berkembang bersama. Semua informasi terperinci ada di portal."),
            Mail("notification", "Aktivitas Tidak Biasa Terdeteksi", "7 Oct", "Kami mendeteksi aktivitas yang tidak biasa di akun Anda. Harap periksa riwayat aktivitas akun Anda dan lakukan pembaruan keamanan jika diperlukan. Keselamatan akun Anda adalah prioritas utama kami. Hubungi support untuk bantuan lebih lanjut. Terima kasih atas perhatian Anda."),
            Mail("promo", "Promo Diskon Akhir Tahun", "5 Oct", "Dapatkan diskon besar-besaran akhir tahun hanya untuk Anda! Penawaran ini berlaku hingga akhir bulan dan mencakup produk pilihan kami. Segera manfaatkan kesempatan ini untuk menikmati harga terbaik. Jangan lewatkan! Stok terbatas dan berlaku untuk semua pengguna. Nikmati belanja hemat!"),
            Mail("noreply", "Konfirmasi Perubahan Password", "2 Oct", "Anda telah berhasil mengubah kata sandi akun Anda. Jika Anda merasa tidak melakukan perubahan ini, segera hubungi tim dukungan kami untuk mengamankan akun Anda. Terima kasih telah menggunakan layanan kami dengan aman. Kami selalu berupaya menjaga keamanan Anda."),
            Mail("contact", "Selamat Datang di Layanan Kami", "1 Oct", "Selamat datang! Kami sangat senang Anda bergabung dengan kami. Jika ada yang bisa kami bantu atau jika Anda memiliki pertanyaan yang ingin diajukan, jangan ragu untuk menghubungi tim dukungan. Terima kasih telah mempercayakan layanan kami sebagai pilihan utama Anda. Selamat bergabung!"),
            Mail("support", "Bantuan Langganan Anda", "29 Sep", "Kami melihat Anda telah berlangganan paket premium kami. Nikmati semua fitur eksklusif yang tersedia hanya untuk Anda. Jika Anda memerlukan bantuan atau informasi lebih lanjut, jangan ragu untuk menghubungi tim dukungan kami kapan saja. Kami akan selalu siap membantu."),
            Mail("promo", "Promo Diskon Spesial Hari Ini", "25 Sep", "Dapatkan diskon khusus hanya hari ini di toko kami. Penawaran ini berlaku untuk produk-produk pilihan dan hanya berlaku untuk waktu terbatas. Jangan lewatkan kesempatan ini untuk mendapatkan harga terbaik di produk favorit Anda. Nikmati pengalaman belanja yang lebih hemat."),
            Mail("newsletter", "Highlight Bulanan", "20 Sep", "Inilah rangkuman berita dan highlight terbaik bulan ini. Dari tips terbaru hingga artikel inspiratif, semuanya dikemas dalam newsletter bulanan kami. Terima kasih telah menjadi bagian dari komunitas kami. Tetap terhubung dengan kami untuk informasi dan update menarik setiap bulan."),
            Mail("reminder", "Pengingat Rapat Mingguan", "18 Sep", "Pengingat: Rapat mingguan akan diadakan besok pada pukul 10 pagi. Harap bergabung tepat waktu melalui tautan yang telah diberikan di email sebelumnya. Jika ada pertanyaan, hubungi sekretariat untuk informasi lebih lanjut. Terima kasih atas partisipasi dan perhatian Anda."),
            Mail("info", "Pengumuman Maintenance Sistem", "15 Sep", "Kami akan melakukan maintenance pada server kami besok malam. Selama maintenance, beberapa fitur mungkin tidak tersedia untuk sementara. Kami akan berusaha untuk menyelesaikan sesegera mungkin. Terima kasih atas kesabaran dan pengertiannya. Layanan akan segera kembali normal."),
            Mail("alert", "Peringatan Keamanan Akun", "10 Sep", "Kami mendeteksi beberapa aktivitas mencurigakan di akun Anda. Demi keamanan, harap perbarui kata sandi Anda dan tinjau riwayat login Anda secara berkala. Jika butuh bantuan, segera hubungi layanan dukungan kami. Keamanan dan kenyamanan Anda adalah prioritas kami."),
            Mail("support", "Dukungan Teknis 24/7", "8 Sep", "Dapatkan dukungan teknis kapan saja untuk membantu Anda dengan kebutuhan teknologi Anda. Tim kami tersedia 24/7 untuk menjawab pertanyaan dan memberikan solusi terbaik untuk kebutuhan Anda. Kami berkomitmen untuk memberikan layanan pelanggan yang responsif dan efektif."),
            Mail("marketing", "Produk Baru Telah Tersedia", "5 Sep", "Lihat produk terbaru kami di katalog online kami. Produk-produk ini dirancang untuk memenuhi kebutuhan Anda. Dapatkan diskon spesial untuk pembelian pertama Anda. Jangan lewatkan kesempatan untuk mencoba produk terbaru kami yang dirancang khusus untuk kenyamanan Anda.")
        )



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mailAdapter = MailAdapter(mailList) { mail ->
            // Saat item diklik, buka DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("MAIL_DETAIL", mail)
            startActivity(intent)
        }
        recyclerView.adapter = mailAdapter
    }
}
